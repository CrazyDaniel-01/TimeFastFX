package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.EnvioDAO;
import fasttimefx.dao.PaqueteDAO;
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.Paquete;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import observador.NotificadorOperaciones;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class FormularioPaqueteFXMLController implements Initializable {

    private NotificadorOperaciones observador;
    private Paquete paqueteEdicion;
    private boolean modoEdicion = false;

    @FXML
    private ObservableList<Envio> envio;
    @FXML
    private Label errorDescripcion;
    @FXML
    private TextField tfDescripcion;
    @FXML
    private Label errorPeso;
    @FXML
    private TextField tfPeso;
    @FXML
    private Label errorAlto;
    @FXML
    private TextField tfAlto;
    @FXML
    private Label errorAncho;
    @FXML
    private TextField tfAncho;
    @FXML
    private Label errorProfundidad;
    @FXML
    private TextField tfProfundidad;
    @FXML
    private Button btnGuardarPaquete;
    @FXML
    private ComboBox<Envio> cbNumeroGuia;
    @FXML
    private Label errorGuia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarEnvios();
    }

    public void inicializarValores(NotificadorOperaciones observador, Paquete paqueteEdicion) {
        this.observador = observador;
        this.paqueteEdicion = paqueteEdicion;
        if (paqueteEdicion != null) {
            modoEdicion = true;
            cargarDatosEdicion();
        }
    }

private void cargarDatosEdicion() {
    tfDescripcion.setText(paqueteEdicion.getDescripcionPaquete());
    tfPeso.setText(paqueteEdicion.getPeso().toString());
    tfAlto.setText(paqueteEdicion.getAlto().toString());
    tfAncho.setText(paqueteEdicion.getAncho().toString());
    tfProfundidad.setText(paqueteEdicion.getProfundidad().toString());

    if (envio == null || envio.isEmpty()) {
        Utilidades.mostrarNotificacion(
                "Error",
                "No se puede seleccionar el número de guía porque no hay datos cargados.",
                Alert.AlertType.ERROR
        );
        return;
    }

    System.out.println("Número de guía esperado: " + paqueteEdicion.getNumeroGuia());
    int posicion = buscarNumeroGuia(paqueteEdicion.getNumeroGuia());
    if (posicion >= 0) {
        cbNumeroGuia.getSelectionModel().select(posicion);
        System.out.println("Número de guía seleccionado en ComboBox: " + envio.get(posicion));
    } else {
        Utilidades.mostrarNotificacion(
                "Error",
                "No se encontró el número de guía especificado.",
                Alert.AlertType.ERROR
        );
    }
}


   @FXML
private void clickBotonGuardar(ActionEvent event) {
    if (validarCampos()) {
        Paquete paquete = new Paquete();
        paquete.setDescripcionPaquete(tfDescripcion.getText());
        paquete.setAlto(Float.parseFloat(tfAlto.getText()));
        paquete.setAncho(Float.parseFloat(tfAncho.getText()));
        paquete.setProfundidad(Float.parseFloat(tfProfundidad.getText()));
        paquete.setPeso(Float.parseFloat(tfPeso.getText()));

        Envio envioSeleccionado = cbNumeroGuia.getSelectionModel().getSelectedItem();
        if (envioSeleccionado != null) {
            paquete.setNumeroGuia(envioSeleccionado.getNumeroGuia());
        } else {
            Utilidades.mostrarNotificacion("Error", "Seleccione un número de guía.", Alert.AlertType.ERROR);
            return;
        }

        if (!modoEdicion) {
            guardarDatosPaquete(paquete);
        } else {
            paquete.setIdPaquete(paqueteEdicion.getIdPaquete());
            editarDatosPaquete(paquete);
        }
    }
}

private void guardarDatosPaquete(Paquete paquete) {
    System.out.println("Datos del paquete a guardar: ");
    System.out.println("Descripción: " + paquete.getDescripcionPaquete());
    System.out.println("Peso: " + paquete.getPeso());
    System.out.println("Alto: " + paquete.getAlto());
    System.out.println("Ancho: " + paquete.getAncho());
    System.out.println("Profundidad: " + paquete.getProfundidad());
    System.out.println("Número de Guía: " + paquete.getNumeroGuia());
    
    Mensaje msj = PaqueteDAO.registrarPaquete(paquete);
    if (!msj.isError()) {
        Utilidades.mostrarNotificacion("Registro exitoso",
                "La información del paquete fue registrada exitosamente.",
                Alert.AlertType.INFORMATION);
        cerrarVentana();
        observador.notificarOperacion("Nuevo Registro", paquete.getDescripcionPaquete());
    } else {
        Utilidades.mostrarNotificacion("Error al guardar", msj.getMensaje(), Alert.AlertType.ERROR);
    }
}
    private void editarDatosPaquete(Paquete paquete) {
        Mensaje msj = PaqueteDAO.actualizarPaquete(paquete);
        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Actualización exitosa",
                    "La información del paquete fue actualizada exitosamente.",
                    Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Edición de Registro", paquete.getDescripcionPaquete());
        } else {
            Utilidades.mostrarNotificacion("Error al actualizar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    private void cerrarVentana() {
        Stage base = (Stage) tfPeso.getScene().getWindow();
        base.close();
    }

    private boolean validarCampos() {
        boolean camposValidos = true;

        if (tfDescripcion.getText().isEmpty()) {
            camposValidos = false;
            errorDescripcion.setText("Por favor ingrese una descripción.");
        } else {
            errorDescripcion.setText("");
        }

        try {
            if (Float.parseFloat(tfPeso.getText()) <= 0) {
                camposValidos = false;
                errorPeso.setText("Por favor ingrese un peso válido.");
            } else {
                errorPeso.setText("");
            }
        } catch (NumberFormatException e) {
            camposValidos = false;
            errorPeso.setText("El peso debe ser un número.");
        }

        if (cbNumeroGuia.getItems().isEmpty()) {
            camposValidos = false;
            errorGuia.setText("No hay números de guía disponibles.");
        } else if (cbNumeroGuia.getSelectionModel().isEmpty()) {
            camposValidos = false;
            errorGuia.setText("Por favor escoja un envío.");
        } else {
            errorGuia.setText("");
        }

        return camposValidos;
    }

   private void cargarEnvios() {
    envio = FXCollections.observableArrayList();
    List<Envio> listaWS = EnvioDAO.obtenerNumerosGuias();
    if (listaWS != null && !listaWS.isEmpty()) {
        envio.addAll(listaWS);
        cbNumeroGuia.setItems(envio);
        System.out.println("Envios cargados:");
        for (Envio e : listaWS) {
            System.out.println("Número de Guía: " + e.getNumeroGuia());
        }
    } else {
        Utilidades.mostrarNotificacion("ERROR AL CARGAR",
                "No se pudieron cargar los envíos. Por favor, inténtelo más tarde.",
                Alert.AlertType.ERROR);
    }
}

private int buscarNumeroGuia(String numeroGuia) {
    for (int i = 0; i < envio.size(); i++) {
        if (envio.get(i).getNumeroGuia().equals(numeroGuia)) {
            return i;
        }
    }
    return -1;
}
}
