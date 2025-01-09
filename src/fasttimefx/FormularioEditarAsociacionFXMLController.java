package fasttimefx;

import Utilidades.Utilidades;
import com.google.gson.Gson;
import fasttimefx.dao.AsociarConductorDAO;
import fasttimefx.pojo.AsociacionVehicular;
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.Unidad;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import observador.NotificadorOperaciones;

public class FormularioEditarAsociacionFXMLController implements Initializable {

    private Envio envioAsignacion;
    private NotificadorOperaciones observador;
    private Unidad unidadEdicion;
    private Colaborador colaboradorEdicion;
    private ObservableList<Colaborador> colaborador;
    private ObservableList<Unidad> unidad;

    @FXML
    private ComboBox<Colaborador> cbColaborador;
    @FXML
    private ComboBox<Unidad> cbUnidad;
    @FXML
    private Label errorColaborador;
    @FXML
    private Label errorUnidad;
    @FXML
    private Button btnGuardarAsociacion;
    @FXML
    private Button btnCancelarAsociacion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatosColaborador();
        cargarDatosUnidad();
    }

    public void inicializarValores(Colaborador colaborador, Unidad unidad) {
    this.colaboradorEdicion = colaborador;
    this.unidadEdicion = unidad;

    if (colaboradorEdicion != null && colaboradorEdicion.getIdConductor() != null) {
        int index = buscarIdColaborador(colaboradorEdicion.getIdConductor());
        if (index != -1) {
            cbColaborador.getSelectionModel().select(index);
        } else {
            System.err.println("No se encontró un colaborador válido para seleccionar.");
        }
    } else {
        System.err.println("colaboradorEdicion o idConductor es null.");
    }

    if (unidadEdicion != null && unidadEdicion.getIdUnidad() != null) {
        int index = buscarIdUnidad(unidadEdicion.getIdUnidad());
        if (index != -1) {
            cbUnidad.getSelectionModel().select(index);
        } else {
            System.err.println("No se encontró una unidad válida para seleccionar.");
        }
    } else {
        System.err.println("unidadEdicion o idUnidad es null.");
    }
}


    private void cargarDatosColaborador() {
        colaborador = FXCollections.observableArrayList();
        List<Colaborador> listaWS = AsociarConductorDAO.obtenerColaborador();
        if (listaWS != null && !listaWS.isEmpty()) {
            colaborador.addAll(listaWS);
            cbColaborador.setItems(colaborador);
        } else {
            Utilidades.mostrarNotificacion(
                "Error",
                "No hay Conductores disponibles. Por favor, inténtelo más tarde.",
                Alert.AlertType.INFORMATION
            );
        }
    }

    private void cargarDatosUnidad() {
        unidad = FXCollections.observableArrayList();
        List<Unidad> listaWS = AsociarConductorDAO.obtenerUnidadLibre();
        if (listaWS != null && !listaWS.isEmpty()) {
            unidad.addAll(listaWS);
            cbUnidad.setItems(unidad);
        } else {
            Utilidades.mostrarNotificacion(
                "Error",
                "No hay unidades disponibles. Por favor, inténtelo más tarde.",
                Alert.AlertType.INFORMATION
            );
        }
    }

   private int buscarIdColaborador(int idConductor) {
    if (colaborador == null) {
        System.err.println("La lista de colaboradores no está inicializada.");
        return -1;
    }

    for (int i = 0; i < colaborador.size(); i++) {
        if (colaborador.get(i).getIdConductor() == idConductor) {
            return i;
        }
    }
    System.err.println("No se encontró el colaborador con idConductor: " + idConductor);
    return -1;
}

private int buscarIdUnidad(int idUnidad) {
    if (unidad == null) {
        System.err.println("La lista de unidades no está inicializada.");
        return -1;
    }

    for (int i = 0; i < unidad.size(); i++) {
        if (unidad.get(i).getIdUnidad() == idUnidad) {
            return i;
        }
    }
    System.err.println("No se encontró la unidad con idUnidad: " + idUnidad);
    return -1;
}




    @FXML
    private void clicGuardarAsociacion(ActionEvent event) {
        if (validarCampos()) {
            Integer idConductor = cbColaborador.getSelectionModel().getSelectedItem().getIdConductor();
            Integer idUnidad = cbUnidad.getSelectionModel().getSelectedItem().getIdUnidad();
            guardarDatos(idConductor, idUnidad);
        }
    }

    private void guardarDatos(Integer idConductor, Integer idUnidad) {
        AsociacionVehicular asociacion = new AsociacionVehicular(idConductor, idUnidad);
        Gson gson = new Gson();
        String jsonAsociacion = gson.toJson(asociacion);

        Mensaje msj = AsociarConductorDAO.registrarAsociacion(jsonAsociacion);

        if (!msj.isError()) {
            Utilidades.mostrarNotificacion(
                "Registro exitoso",
                "La información se guardó correctamente.",
                Alert.AlertType.INFORMATION
            );
            cerrarVentana();
            if (observador != null) {
                observador.notificarOperacion("Nuevo Registro", idConductor.toString());
            }
        } else {
            Utilidades.mostrarNotificacion(
                "Error al guardar",
                msj.getMensaje(),
                Alert.AlertType.ERROR
            );
        }
    }

    private boolean validarCampos() {
        boolean validos = true;

        if (cbColaborador.getSelectionModel().isEmpty()) {
            validos = false;
            errorColaborador.setText("Por favor, seleccione un colaborador.");
        } else {
            errorColaborador.setText("");
        }

        if (cbUnidad.getSelectionModel().isEmpty()) {
            validos = false;
            errorUnidad.setText("Por favor, seleccione una unidad.");
        } else {
            errorUnidad.setText("");
        }

        return validos;
    }

    private void cerrarVentana() {
        Stage stage = (Stage) cbColaborador.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clicCancelarAsociacion(ActionEvent event) {
        cerrarVentana();
    }
}
