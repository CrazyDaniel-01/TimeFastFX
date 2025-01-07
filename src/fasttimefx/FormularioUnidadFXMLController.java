package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.TipoDAO;
import fasttimefx.dao.UnidadDAO;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.Tipo;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import observador.NotificadorOperaciones;

public class FormularioUnidadFXMLController implements Initializable {

    private NotificadorOperaciones observador;
    private Unidad unidadEdicion;
    private boolean modoEdicion = false;

    private ObservableList<Tipo> tipo;
    @FXML
    private TextField tfMarca;
    @FXML
    private TextField tfAnio;
    @FXML
    private ComboBox<Tipo> cbTipo;
    @FXML
    private TextField tfVin;
    @FXML
    private Button btnAgregar;
    @FXML
    private Label errorMarca;
    @FXML
    private Label errorModelo;
    @FXML
    private Label errorAnio;
    @FXML
    private Label errorTipo;
    @FXML
    private Label errorVin;
    @FXML
    private TextField tfModelo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTiposUnidad();
    }

    @FXML
    private void clicGuardarUnidad(ActionEvent event) {
        if (validarCampos()) {
            Unidad unidad = new Unidad();
            if (!modoEdicion) {
                unidad.setMarca(tfMarca.getText());
                unidad.setModelo(tfModelo.getText());
                unidad.setAño(tfAnio.getText());
                unidad.setVin(tfVin.getText());
                unidad.setIdTipo(cbTipo.getSelectionModel().getSelectedItem().getIdTipo());
                guardarDatosUnidad(unidad);
            } else {
                unidad.setIdUnidad(this.unidadEdicion.getIdUnidad());
                unidad.setMarca(tfMarca.getText());
                unidad.setModelo(tfModelo.getText());
                unidad.setAño(tfAnio.getText());
                unidad.setVin(tfVin.getText());
                unidad.setIdTipo(cbTipo.getSelectionModel().getSelectedItem().getIdTipo());
                editarDatosUnidad(unidad);
            }
        }
    }

    public void inicializarValores(NotificadorOperaciones observador, Unidad unidadEdicion) {
        this.observador = observador;
        this.unidadEdicion = unidadEdicion;
        if (unidadEdicion != null) {
            modoEdicion = true;
            cargarDatosEdicion();
        }
    }

    public boolean validarCampos() {
        boolean camposValidos = true;

        if (tfMarca.getText().isEmpty()) {
            camposValidos = false;
            errorMarca.setText("Por favor ingrese una marca");
        } else {
            errorMarca.setText("");
        }
        if (tfModelo.getText().isEmpty()) {
            camposValidos = false;
            errorModelo.setText("Por favor ingrese un modelo");
        } else {
            errorModelo.setText("");
        }
        try {
            int anio = Integer.parseInt(tfAnio.getText());
            if (anio < 1950 || anio > 2026) {
                camposValidos = false;
                errorAnio.setText("Por favor ingrese un año válido entre 1950 y 2026");
            } else {
                errorAnio.setText("");
            }
        } catch (NumberFormatException e) {
            camposValidos = false;
            errorAnio.setText("El año debe ser un número");
        }
        if (tfVin.getText().isEmpty()) {
            camposValidos = false;
            errorVin.setText("Por favor ingrese un VIN");
        } else {
            errorVin.setText("");
        }
        if (cbTipo.getSelectionModel().isEmpty()) {
            camposValidos = false;
            errorTipo.setText("Por favor seleccione un tipo de vehículo");
        } else {
            errorTipo.setText("");
        }
        return camposValidos;
    }

    private void cargarDatosEdicion() {
    tfMarca.setText(this.unidadEdicion.getMarca());
    tfModelo.setText(this.unidadEdicion.getModelo());
    tfAnio.setText(this.unidadEdicion.getAño());
    tfVin.setText(this.unidadEdicion.getVin());

    // Verificar que los tipos ya estén cargados en el ComboBox
    if (cbTipo.getItems() == null || cbTipo.getItems().isEmpty()) {
        System.out.println("Error: Los tipos no están cargados en el ComboBox.");
        Utilidades.mostrarNotificacion(
                "Error",
                "Los tipos de vehículo no se cargaron correctamente. Por favor, intente de nuevo.",
                Alert.AlertType.ERROR
        );
        return;
    }

    // Buscar el índice del tipo correspondiente
    int posicion = buscarIdTipo(this.unidadEdicion.getIdTipo());
    if (posicion >= 0) {
        // Seleccionar el tipo en el ComboBox
        cbTipo.getSelectionModel().select(posicion);
    } else {
        System.out.println("Error: No se encontró el tipo con ID " + this.unidadEdicion.getIdTipo());
        Utilidades.mostrarNotificacion(
                "Error",
                "No se encontró el tipo de vehículo con el ID especificado.",
                Alert.AlertType.ERROR
        );
    }

    // Deshabilitar el campo VIN para evitar modificaciones
    tfVin.setDisable(true);
}

    private void guardarDatosUnidad(Unidad unidad) {
        Mensaje msj = UnidadDAO.registrarUnidad(unidad);
        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Registro exitoso", "La información de la unidad " + unidad.getMarca()
                    + " " + unidad.getModelo() + " " + unidad.getAño() + ", fue registrada exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Nuevo Registro", unidad.getMarca());
        } else {
            Utilidades.mostrarNotificacion("Error al guardar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    private void editarDatosUnidad(Unidad unidad) {
        Mensaje msj = UnidadDAO.actualizarUnidad(unidad);
        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Actualización exitosa", "La información de la unidad " + unidad.getMarca()
                    + " " + unidad.getModelo() + " " + unidad.getAño() + " fue actualizada exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Edición de Registro", unidad.getModelo());

        } else {
            Utilidades.mostrarNotificacion("Error al actualizar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    private void cerrarVentana() {
        Stage base = (Stage) tfMarca.getScene().getWindow();
        base.close();
    }

    private void cargarTiposUnidad() {
        tipo = FXCollections.observableArrayList();
        List<Tipo> listaWS = TipoDAO.obtenerTipos();

        if (listaWS != null && !listaWS.isEmpty()) {
            tipo.addAll(listaWS);
            cbTipo.setItems(tipo);
            System.out.println("Tipos cargados correctamente:");
            for (Tipo t : listaWS) {
                System.out.println("ID: " + t.getIdTipo() + ", Descripción: " + t.getDescripcionTipo());
            }
        } else {
            Utilidades.mostrarNotificacion("Error al cargar",
                    "No se pudieron cargar los tipos de unidad. Por favor, inténtelo más tarde.",
                    Alert.AlertType.ERROR);
            System.out.println("Error: La lista obtenida es nula o está vacía.");
        }
    }

private int buscarIdTipo(int idTipo) {
    ObservableList<Tipo> tipoUnidades = cbTipo.getItems();
    for (int i = 0; i < tipoUnidades.size(); i++) {
        if (tipoUnidades.get(i).getIdTipo() == idTipo) {
            return i; // Devuelve el índice si encuentra el tipo
        }
    }
    return -1; // Retorna -1 si no encuentra el tipo
}

}
