package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.AsociarConductorDAO;
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.Unidad;
import fasttimefx.pojo.AsociacionVehicular;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import observador.NotificadorOperaciones;
import com.google.gson.Gson;
import fasttimefx.pojo.Envio;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FormularioAsociarConductorFXMLController implements Initializable {

    
    private Envio envioAsignacion;
    private NotificadorOperaciones observador;
    private Unidad unidadEdicion;
    private Colaborador colaboradorEdicion;
    private boolean modoEdicion = false;
    private boolean modoAsignarEnvio=false;

    private ObservableList<Colaborador> colaborador;
    private ObservableList<Unidad> unidad;
    private ObservableList<AsociacionVehicular> asociaciones;
    
    @FXML
    private ComboBox<Colaborador> cbColaborador;
    @FXML
    private ComboBox<Unidad> cbUnidad;
    @FXML
    private Label errorColaborador;
    @FXML
    private Label errorUnidad;
    @FXML
    private TableView<AsociacionVehicular> tvConductores;
    @FXML
    private TableColumn colUnidad;
    @FXML
    private TableColumn colConductor;
    @FXML
    private TableColumn colEnvio;
    @FXML
    private Button btnAsociarConductor;
    @FXML
    private Button btnEliminarAsociacion;
    @FXML
    private Button btnEditarAsociacion;
    @FXML
    private Button btnEditarAsociacion1;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    if (cbColaborador == null) {
        System.err.println("cbColaborador no está inicializado.");
    }
    if (cbUnidad == null) {
        System.err.println("cbUnidad no está inicializado.");
    }
    configurarTabla();
    cargarDatosColaborador();
    cargarDatosUnidad();
    cargarTabla();
    
}



    public void inicializarValores(NotificadorOperaciones observador, Unidad unidad, Colaborador colaborador) {
        this.observador = observador;
        this.unidadEdicion = unidad;
        this.colaboradorEdicion = colaborador;
        if (unidad != null) {
            modoEdicion = true;
            cargarDatosEdicion();
        }
        
    }
    private void recibirEnvio(Envio envio){
        this.envioAsignacion=envio;
        if(envio!=null){
            cbUnidad.setDisable(true);
            cbColaborador.setDisable(true);
        }
    }

    private void cargarDatosEdicion() {
        if (unidadEdicion != null && colaboradorEdicion != null) {
            int posicionColaborador = buscarIdColaborador(colaboradorEdicion.getIdConductor());
            cbColaborador.getSelectionModel().select(posicionColaborador);

            int posicionUnidad = buscarIdUnidad(unidadEdicion.getIdUnidad());
            cbUnidad.getSelectionModel().select(posicionUnidad);
        }
    }

   private void cargarDatosColaborador() {
    System.out.println("Iniciando carga de colaboradores...");
    colaborador = FXCollections.observableArrayList();
    List<Colaborador> listaWS = AsociarConductorDAO.obtenerColaboradorLibre();
    if (listaWS != null && !listaWS.isEmpty()) {
        colaborador.addAll(listaWS);
        cbColaborador.setItems(colaborador);
        System.out.println("Colaboradores cargados: " + colaborador);
    } else {
        System.err.println("Error: La lista de colaboradores está vacía o es null.");
        Utilidades.mostrarNotificacion(
            "",
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
                "",
                "No hay unidades Disponibles. Por favor, inténtelo más tarde.",
                Alert.AlertType.INFORMATION
                    
            );
        }
    }

    private int buscarIdColaborador(int idConductor) {
        for (int i = 0; i < colaborador.size(); i++) {
            if (colaborador.get(i).getIdConductor() == idConductor) {
                return i;
            }
        }
        return -1;
    }

    private int buscarIdUnidad(int idUnidad) {
        for (int i = 0; i < unidad.size(); i++) {
            if (unidad.get(i).getIdUnidad() == idUnidad) {
                return i;
            }
        }
        return -1;
    }

 @FXML
private void clicGuardarAsociacion(ActionEvent event) {
    if (validarCampos()) {
        // Cambiar a obtener idConductor
        Integer idConductor = cbColaborador.getSelectionModel().getSelectedItem().getIdConductor();
        Integer idUnidad = cbUnidad.getSelectionModel().getSelectedItem().getIdUnidad();

        guardarDatos(idConductor, idUnidad);
    }
}


   

private void guardarDatos(Integer idConductor, Integer idUnidad) {
    AsociacionVehicular asociacion = new AsociacionVehicular(idConductor, idUnidad);

    // Convertir el objeto asociacion a JSON
    Gson gson = new Gson();
    String jsonAsociacion = gson.toJson(asociacion);

    System.out.println("Datos en JSON: " + jsonAsociacion); // Debug: Verifica el JSON generado

    // Llamar al método que registra la asociación, enviando el JSON
    Mensaje msj = AsociarConductorDAO.registrarAsociacion(jsonAsociacion);

    // Manejar la respuesta
    if (!msj.isError()) {
        Utilidades.mostrarNotificacion(
            "Registro exitoso",
            "La información se guardó correctamente.",
            Alert.AlertType.INFORMATION
        );
        cerrarVentana();
        observador.notificarOperacion("Nuevo Registro", idConductor.toString());
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
        Stage stage = (Stage)cbColaborador.getScene().getWindow();
        stage.close();
    }

    private void configurarTabla() {
        colUnidad.setCellValueFactory(new PropertyValueFactory<>("unidad"));
        colConductor.setCellValueFactory(new PropertyValueFactory<>("conductor"));
        colEnvio.setCellValueFactory(new PropertyValueFactory<>("envioAsociado"));
        }

    private void cargarTabla() {
        tvConductores.getItems().clear();
        asociaciones= FXCollections.observableArrayList();
        List<AsociacionVehicular> listAsociaciones = AsociarConductorDAO.obtenerAsociaciones();
        if (listAsociaciones != null) {
            asociaciones.addAll(listAsociaciones);
            tvConductores.setItems(asociaciones);
        } else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de colaboradores.", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void clicEliminarAsociacion(ActionEvent event) {
    }

    @FXML
    private void clicEditarAsociacion(ActionEvent event) {
    }
    @FXML
    private void clicAsociarEnvio(ActionEvent event){
        
    }
}
 