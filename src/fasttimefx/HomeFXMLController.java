
package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.ClienteDAO;
import fasttimefx.dao.ColaboradorDAO;
import static fasttimefx.dao.ColaboradorDAO.eliminarColaborador;
import fasttimefx.dao.EnvioDAO;
import fasttimefx.dao.PaqueteDAO;
import fasttimefx.dao.UnidadDAO;
import fasttimefx.pojo.Cliente;
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.Paquete;
import fasttimefx.pojo.Unidad;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import static javafx.stage.Modality.APPLICATION_MODAL;
import javafx.stage.Stage;
import observador.NotificadorOperaciones;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class HomeFXMLController implements Initializable, NotificadorOperaciones {

    
    private ObservableList<Unidad> unidades;
    private ObservableList <Colaborador> colaboradores;
    private ObservableList <Cliente> clientes;
    private ObservableList <Envio> envios;
    private ObservableList <Paquete> paquetes;
   
    @FXML
    private Pane pnlColaboradores;
    @FXML
    private Pane pnlUnidades;
    @FXML
    private Pane pnlClientes;
    @FXML
    private Pane pnlPaquetes;
    @FXML
    private Pane pnlEnvios;
    @FXML
    private TableView<Unidad> tvUnidad;
    @FXML
    private TableView<Envio> tvEnvios;
    @FXML
    private TableView<Paquete> tvPaquetes;
    @FXML
    private TableView<Cliente> tvCliente;
    @FXML
    private TableView<Colaborador> tvColaborador;
    @FXML
    private Button btnColaboradores;
    @FXML
    private Button btnUnidades;
    @FXML
    private Button btnClientes;
    @FXML
    private Button btnEnvios;
    @FXML
    private Button btnPaquetes;
    
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoP;
    @FXML
    private TableColumn colApellidoM;
    @FXML
    private TableColumn colCURP;
    @FXML
    private TableColumn colCorreo;
    @FXML
    private TableColumn colRol;
    @FXML
    private TableColumn colMarca;
    @FXML
    private TableColumn colModelo;
    @FXML
    private TableColumn colTipo;
    @FXML
    private TableColumn colAño;
    @FXML
    private TableColumn colVIN;
    @FXML
    private TableColumn colNumeroIn;
    @FXML
    private TableColumn colEnvio;
    @FXML
    private TableColumn colOrigen;
    @FXML
    private TableColumn colGuia;
    @FXML
    private TableColumn colDestino;
    @FXML
    private TableColumn colCosto;
    @FXML
    private TableColumn colConductor;
    @FXML
    private TableColumn colNumeroGP;
    @FXML
    private TableColumn colDescripcion;
    @FXML
    private TableColumn colPeso;
    @FXML
    private TableColumn colAlto;
    @FXML
    private TableColumn colAncho;
    @FXML
    private TableColumn colProfundidad;
    @FXML
    private TableColumn colNombreCliente;
    @FXML
    private TableColumn colApellidoPC;
    @FXML
    private TableColumn colApellidoMC;
    @FXML
    private TableColumn colTelefonoC;
    @FXML
    private TableColumn colCorreoC;
    @FXML
    private TableColumn colDireccionC;
    @FXML
    private TableColumn colFotografia;
    @FXML
    private Button btnEditarUnidad;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableColumn colLicencia;
    @FXML
    private TextField buscaColaborador;
    @FXML
    private TextField buscaCliente;
    @FXML
    private TextField buscaUnidad;
    @FXML
    private ImageView imgBuscarUnidad;
    @FXML
    private Button btnAgregarUnidad;
    @FXML
    private Button btnEliminarUnidad;
    @FXML
    private Button btnAsociarUnidad;
    @FXML
    private Button btnAgregarEnvio;
    @FXML
    private Button btnEditarEnvio;
    @FXML
    private Button btnEliminarEnvio;
    @FXML
    private Button btnAsignarConductor;
    @FXML
    private Button btnAsctualizarEstado;
    @FXML
    private ImageView imgBuscarCliente;
    @FXML
    private ImageView imgBuscarColaborador;
    @FXML
    private TableColumn colEstado;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarDatos();
        agregarColumnaFotografia();
    }    
    @FXML
    public void panelClientes(ActionEvent actionEvent){
        pnlClientes.toFront();
        
    }
    @FXML
    public void panelEnvios(ActionEvent actionEvent){
        pnlEnvios.toFront();
    }
    @FXML
    public void panelPaquetes(ActionEvent actionEvent){
        pnlPaquetes.toFront();
    }
    @FXML
    public void panelUnidades(ActionEvent actionEvent){
        pnlUnidades.toFront();
    }
    @FXML
    public void panelColaboradores(ActionEvent actionEvent){
        pnlColaboradores.toFront();
    }

    @Override
    public void notificarOperacion(String tipo, String nombre) {
        recargarTablaColaboradores();
        recargarTablaUnidades();
        recargarTablaClientes();
        recargarTablaPaquetes();
        recargarTablaEnvio();
        
        
        
    }
    private void cargarDatos(){
        recargarTablaColaboradores();
        recargarTablaUnidades();
        recargarTablaClientes();
        recargarTablaPaquetes();
        recargarTablaEnvio();
    }
    @FXML
    public void buscarColaboradores() {
        String nombreBuscado = buscaColaborador.getText().trim();
        List<Colaborador> resultados = ColaboradorDAO.buscarColaboradoresPorNombre(nombreBuscado);
        colaboradores.clear();
        if (resultados != null && !resultados.isEmpty()) {
            colaboradores.addAll(resultados);
            tvColaborador.setItems(colaboradores);
        } else {
            }
    }
    @FXML
    public void buscarCliente() {
        String nombreClienteBuscado = buscaCliente.getText().trim();
        List<Cliente> resultados = ClienteDAO.buscarClientesPorNombre(nombreClienteBuscado);
        clientes.clear();
        if (resultados != null && !resultados.isEmpty()) {
            clientes.addAll(resultados);
            tvCliente.setItems(clientes);
        } else {
            }
    }
    
    @FXML
    public void buscarUnidad() {
    String nombreUnidadBuscada = buscaUnidad.getText().trim();
    List<Unidad> resultados = UnidadDAO.buscarUnidadesPorMarca(nombreUnidadBuscada);
    unidades.clear();
    if (resultados != null && !resultados.isEmpty()) {
        unidades.addAll(resultados);
        tvUnidad.setItems(unidades);
    } else {
       }
}

    
    private void irFormularioColaborador(NotificadorOperaciones observador, Colaborador colaborador){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioColaboradorFXML.fxml"));
            
            Parent root= loader.load();
            
            FormularioColaboradorFXMLController controlador = loader.getController();
            controlador.inicializarValores(observador, colaborador);
            
            Stage escenarioForm=new Stage();
            Scene escenarioFormulario = new Scene(root);
            escenarioForm.setScene(escenarioFormulario);
            escenarioForm.setTitle("Administacion de colaboradores");
            escenarioForm.initModality(APPLICATION_MODAL);
            escenarioForm.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void irFormularioCliente(NotificadorOperaciones observador, Cliente cliente) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioClienteFXML.fxml"));
            Parent root = loader.load();
            FormularioClienteFXMLController controlador = loader.getController();
            controlador.inicializarValores(observador, cliente);

            Stage escenarioForm = new Stage();
            Scene escenarioFormulario = new Scene(root);
            escenarioForm.setScene(escenarioFormulario);
            escenarioForm.setTitle("Administración de clientes");
            escenarioForm.initModality(APPLICATION_MODAL);
            escenarioForm.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void irFormularioUnidad(NotificadorOperaciones observador, Unidad unidad) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioUnidadFXML.fxml"));
            Parent root = loader.load();
            FormularioUnidadFXMLController controlador = loader.getController();
            controlador.inicializarValores(observador, unidad);

            Stage escenarioForm = new Stage();
            Scene escenarioFormulario = new Scene(root);
            escenarioForm.setScene(escenarioFormulario);
            escenarioForm.setTitle("Administración de Unidades");
            escenarioForm.initModality(APPLICATION_MODAL);
            escenarioForm.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void irFormularioAsociarConductor(NotificadorOperaciones observador, Unidad unidad,Colaborador colaborador) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioAsociarConductorFXML.fxml"));
            Parent root = loader.load();
            FormularioAsociarConductorFXMLController controlador = loader.getController();
            controlador.inicializarValores(observador, unidad,colaborador);
            try{
                Envio envio= tvEnvios.getSelectionModel().getSelectedItem();
                if(envio!=null){
                controlador.recibirEnvio(envio); 
                }
                
            }catch(Exception ex){
                
            }

            Stage escenarioForm = new Stage();
            Scene escenarioFormulario = new Scene(root);
            escenarioForm.setScene(escenarioFormulario);
            escenarioForm.setTitle("Asociar Conductor");
            escenarioForm.initModality(APPLICATION_MODAL);
            escenarioForm.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void irFormularioBajaUnidad(NotificadorOperaciones observador, Unidad unidad) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioBajaUnidadFXML.fxml"));
            Parent root = loader.load();
            FormularioBajaUnidadFXMLController controlador = loader.getController();
            controlador.recibirUnidad(observador, unidad);

            Stage escenarioForm = new Stage();
            Scene escenarioFormulario = new Scene(root);
            escenarioForm.setScene(escenarioFormulario);
            escenarioForm.setTitle("Baja de Unidades");
            escenarioForm.initModality(APPLICATION_MODAL);
            escenarioForm.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void irFormularioEstado(NotificadorOperaciones observador, Envio envio) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioStatusEnvioFXML.fxml"));
            Parent root = loader.load();
            FormularioStatusEnvioFXMLController controlador = loader.getController();
            controlador.recibirEnvio(this, envio);
            Stage escenarioForm = new Stage();
            Scene escenarioFormulario = new Scene(root);
            escenarioForm.setScene(escenarioFormulario);
            escenarioForm.setTitle("Gestion de status");
            escenarioForm.initModality(APPLICATION_MODAL);
            escenarioForm.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } //To change body of generated methods, choose Tools | Templates.
    }
    private void irFormularioPaquete(NotificadorOperaciones observador, Paquete paquete) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioPaqueteFXML.fxml"));
            Parent root = loader.load();
            FormularioPaqueteFXMLController controlador = loader.getController();
            controlador.inicializarValores(observador, paquete);

            Stage escenarioForm = new Stage();
            Scene escenarioFormulario = new Scene(root);
            escenarioForm.setScene(escenarioFormulario);
            escenarioForm.setTitle("Gestion de Paquetes");
            escenarioForm.initModality(APPLICATION_MODAL);
            escenarioForm.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        private void irFormularioEnvio(NotificadorOperaciones observador, Envio envio) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioEnvioFXML.fxml"));
            Parent root = loader.load();
            FormularioEnvioFXMLController controlador = loader.getController();
            controlador.inicializarValores(observador, envio);

            Stage escenarioForm = new Stage();
            Scene escenarioFormulario = new Scene(root);
            escenarioForm.setScene(escenarioFormulario);
            escenarioForm.setTitle("Gestion de Paquetes");
            escenarioForm.initModality(APPLICATION_MODAL);
            escenarioForm.showAndWait();
        } catch (Exception ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnAgregarUnidad(ActionEvent event) {
        irFormularioUnidad(this,null);
    }

    @FXML
    private void btnEditarUnidad(ActionEvent event) {
        Unidad unidad = tvUnidad.getSelectionModel().getSelectedItem();
        if (unidad != null) {
            irFormularioUnidad(this, unidad);
        } else {
            Utilidades.mostrarNotificacion("Seleccionar Unidad ", "Para editar, seleccione primero una unidad.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnEliminarUnidad(ActionEvent event) {
        Unidad unidad = tvUnidad.getSelectionModel().getSelectedItem();
        if (unidad != null) {
            irFormularioBajaUnidad(this, unidad);
        } else {
            Utilidades.mostrarNotificacion("Seleccionar Unidad ", "Para dar de baja una unidad, seleccione primero una unidad.", Alert.AlertType.WARNING);
        }
    }
    @FXML
    private void btnAsociarUnidad(ActionEvent event) {
        irFormularioAsociarConductor(this, null,null);
    }

    @FXML
    private void btnAgregarEnvio(ActionEvent event) {
        irFormularioEnvio(this, null);
    }

    @FXML
    private void btnEditarEnvio(ActionEvent event) {
        Envio envio = tvEnvios.getSelectionModel().getSelectedItem();
        if (envio != null) {
            irFormularioEnvio(this,envio);
        } else {
            Utilidades.mostrarNotificacion("Seleccionar el Envio ", "Para editar, seleccione primero un envio.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnEliminarEnvio(ActionEvent event) {
                Envio envio = tvEnvios.getSelectionModel().getSelectedItem();
        if (envio != null) {
            eliminarEnvio(envio.getIdEnvio());
        } else {
            Utilidades.mostrarNotificacion("Seleccionar ENVIO", "Para eliminar, seleccione primero un envio.", Alert.AlertType.WARNING);
        }
    }
    @FXML
    private void btnAsociarConductor(){
        irFormularioAsociarConductor(this, null,null);
    }

    @FXML
    private void btnAgregarPaquete(ActionEvent event) {
        irFormularioPaquete(this,null);
    }

    @FXML
    private void btnEditarPaqute(ActionEvent event) {
        Paquete paquete = tvPaquetes.getSelectionModel().getSelectedItem();
        if (paquete != null) {
            irFormularioPaquete(this, paquete);
        } else {
            Utilidades.mostrarNotificacion("Seleccionar Unidad ", "Para editar un paquete, primero seleccione un paquete.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnEliminarPaquete(ActionEvent event) {
        Paquete paquete = tvPaquetes.getSelectionModel().getSelectedItem();
        if (paquete != null) {
            eliminarPaquete(paquete.getIdPaquete());
        } else {
            Utilidades.mostrarNotificacion("Seleccionar cliente", "Para eliminar, seleccione primero un cliente.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnAgregarCliente(ActionEvent event) {
        irFormularioCliente(this, null);
}

    @FXML
    private void btnEditarCliente(ActionEvent event) {
        Cliente cliente = tvCliente.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            irFormularioCliente(this, cliente);
        } else {
            Utilidades.mostrarNotificacion("Seleccionar cliente", "Para editar, seleccione primero un cliente.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnEliminarCliente(ActionEvent event) {
        Cliente cliente = tvCliente.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            eliminarCliente(cliente.getIdCliente());
        } else {
            Utilidades.mostrarNotificacion("Seleccionar cliente", "Para eliminar, seleccione primero un cliente.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnAgregarColaborador(ActionEvent event) {
        irFormularioColaborador(this,null);
    }

    @FXML
    private void btnEditarColaborador(ActionEvent event) {
   
        Colaborador colaborador= tvColaborador.getSelectionModel().getSelectedItem();
        if(colaborador!=null){
            irFormularioColaborador(this,colaborador);
            
        }else{
            Utilidades.mostrarNotificacion("Seleccionar colaborador", "Para editar seleccione primero un colaborador ", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnEliminarColaborador(ActionEvent event) {
        Colaborador colaborador= tvColaborador.getSelectionModel().getSelectedItem();
        if(colaborador!=null){
            eliminarColaborador(colaborador.getIdColaborador());
        }else{
            Utilidades.mostrarNotificacion("Seleccionar colaborador", "Para eliminar seleccione primero un colaborador ", Alert.AlertType.WARNING);
        }

    }
    private void eliminarColaborador(Integer idColaborador) {

    Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
    confirmacion.setTitle("Confirmar eliminación");
    confirmacion.setHeaderText("¿Estás seguro de que deseas eliminar al colaborador?");
    confirmacion.setContentText("Esta acción no se puede deshacer.");

    Optional<ButtonType> resultado = confirmacion.showAndWait();
    if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
        Mensaje msj = ColaboradorDAO.eliminarColaborador(idColaborador);
        
        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Eliminación exitosa", "El colaborador con número de personal " + idColaborador + " fue eliminado correctamente.", Alert.AlertType.INFORMATION);
            notificarOperacion("eliminar","colaborador");
        } else {
            Utilidades.mostrarNotificacion("Error al eliminar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    }
    private void eliminarCliente(Integer idCliente) {
    Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
    confirmacion.setTitle("Confirmar eliminación");
    confirmacion.setHeaderText("¿Estás seguro de que deseas eliminar al cliente?");
    confirmacion.setContentText("Esta acción no se puede deshacer.");

    Optional<ButtonType> resultado = confirmacion.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            Mensaje msj = ClienteDAO.eliminarCliente(idCliente);

            if (!msj.isError()) {
                Utilidades.mostrarNotificacion("Eliminación exitosa", "El cliente con ID " + idCliente + " fue eliminado correctamente.", Alert.AlertType.INFORMATION);
                notificarOperacion("eliminar", "cliente");
            } else {
                Utilidades.mostrarNotificacion("Error al eliminar", msj.getMensaje(), Alert.AlertType.ERROR);
            }
        }
    }
    private void eliminarPaquete(Integer idPaquete) {
    Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
    confirmacion.setTitle("Confirmar eliminación");
    confirmacion.setHeaderText("¿Estás seguro de que deseas eliminar el paquete?");
    confirmacion.setContentText("Esta acción no se puede deshacer.");

    Optional<ButtonType> resultado = confirmacion.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            Mensaje msj = PaqueteDAO.eliminarPaquete(idPaquete);

            if (!msj.isError()) {
                Utilidades.mostrarNotificacion("Eliminación exitosa", "El paquete con ID " + idPaquete + " fue eliminado correctamente.", Alert.AlertType.INFORMATION);
                notificarOperacion("eliminar", "cliente");
            } else {
                Utilidades.mostrarNotificacion("Error al eliminar", msj.getMensaje(), Alert.AlertType.ERROR);
            }
        }
    }
    
    
      private void eliminarEnvio(Integer idEnvio) {
    Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
    confirmacion.setTitle("Confirmar eliminación");
    confirmacion.setHeaderText("¿Estás seguro de que deseas eliminar el envio?");
    confirmacion.setContentText("Esta acción no se puede deshacer.");

    Optional<ButtonType> resultado = confirmacion.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            Mensaje msj = EnvioDAO.eliminarEnvio(idEnvio);

            if (!msj.isError()) {
                Utilidades.mostrarNotificacion("Eliminación exitosa", "El envio con ID " + idEnvio + " fue eliminado correctamente.", Alert.AlertType.INFORMATION);
                notificarOperacion("eliminar", "envio");
            } else {
                Utilidades.mostrarNotificacion("Error al eliminar", msj.getMensaje(), Alert.AlertType.ERROR);
            }
        }
    }
    @FXML
    private void recargarTablaColaboradores() {
        tvColaborador.getItems().clear();
        cargarDatosColaborador();
    }
    @FXML
    private void recargarTablaClientes() {
        tvCliente.getItems().clear();
        cargarDatosCliente();
    }
    @FXML
    private void recargarTablaUnidades() {
        tvUnidad.getItems().clear();
        cargarDatosUnidad();
    }
    @FXML
    private void recargarTablaPaquetes() {
        tvPaquetes.getItems().clear();
        cargarDatosPaquete();
    }
    @FXML
    private void recargarTablaEnvio() {
        tvEnvios.getItems().clear();
        cargarDatosEnvio();
    }
    private void recargarTablaUnidad(){
        tvUnidad.getItems().clear();
        cargarDatosUnidad();
    }
    
    
    private void configurarTabla() {
        // Colaboradores
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        colApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
        colCURP.setCellValueFactory(new PropertyValueFactory<>("curp"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        colLicencia.setCellValueFactory(new PropertyValueFactory<>("NumeroLicencia"));
        colFotografia.setCellValueFactory(new PropertyValueFactory<>("fotoBase64"));

        // Unidades
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("descripcionTipo"));
        colAño.setCellValueFactory(new PropertyValueFactory<>("año"));
        colVIN.setCellValueFactory(new PropertyValueFactory<>("vin"));
        colNumeroIn.setCellValueFactory(new PropertyValueFactory<>("idInterno"));

        // Envios
        colEnvio.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colOrigen.setCellValueFactory(new PropertyValueFactory<>("origen"));
        colGuia.setCellValueFactory(new PropertyValueFactory<>("noGuia"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("status"));
        colDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        colCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));
        colConductor.setCellValueFactory(new PropertyValueFactory<>("conductor"));

        // Paquetes
        colNumeroGP.setCellValueFactory(new PropertyValueFactory<>("numeroGuia"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcionPaquete"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colAlto.setCellValueFactory(new PropertyValueFactory<>("alto"));
        colAncho.setCellValueFactory(new PropertyValueFactory<>("ancho"));
        colProfundidad.setCellValueFactory(new PropertyValueFactory<>("profundidad"));

        // Clientes
        colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoPC.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        colApellidoMC.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
        colTelefonoC.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCorreoC.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colDireccionC.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        
    
}

    
    private void cargarDatosColaborador() {
        // Cargar datos para colaboradores
        tvColaborador.getItems().clear();
        colaboradores = FXCollections.observableArrayList();
        List<Colaborador> listaColaboradores = ColaboradorDAO.obtenerColaborador();
        if (listaColaboradores != null) {
            colaboradores.addAll(listaColaboradores);
            tvColaborador.setItems(colaboradores);
        } else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de colaboradores.", Alert.AlertType.ERROR);
        }
    }
    private void cargarDatosCliente(){
        clientes = FXCollections.observableArrayList();
        List<Cliente> listaClientes = ClienteDAO.obtenerCliente();
        if (listaClientes != null) {
            clientes.addAll(listaClientes);
            tvCliente.setItems(clientes);
        }else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de cliente.", Alert.AlertType.ERROR);
        }
    }
    private void cargarDatosUnidad(){
        //cargar datos Unidad
        unidades = FXCollections.observableArrayList();
        List<Unidad> listaUnidad = UnidadDAO.obtenerUnidad();
        if (listaUnidad != null) {
            unidades.addAll(listaUnidad);
            tvUnidad.setItems(unidades);
        }else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de unidad.", Alert.AlertType.ERROR);
        }
    }
    public void cargarDatosEnvio(){
        //cargar datos Envio
        envios = FXCollections.observableArrayList();
        List<Envio> listaEnvio = EnvioDAO.obtenerEnvio();
        if (listaEnvio != null) {
            envios.addAll(listaEnvio);
            tvEnvios.setItems(envios);
        }else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de envio.", Alert.AlertType.ERROR);
        }
    }
    public void cargarDatosPaquete(){
        paquetes = FXCollections.observableArrayList();
        List<Paquete> listaPaquete = PaqueteDAO.obtenerPaquete();
        if (listaPaquete != null) {
            paquetes.addAll(listaPaquete);
            tvPaquetes.setItems(paquetes);
        }else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de paquetes.", Alert.AlertType.ERROR);
        }
    }


    @FXML
    private void btnActualizarEstado(ActionEvent event) {
        Envio envio = tvEnvios.getSelectionModel().getSelectedItem();
        if(envio!=null){
            irFormularioEstado(this,envio);
            
        }else{
            Utilidades.mostrarNotificacion("Seleccionar colaborador", "Para editar seleccione primero un colaborador ", Alert.AlertType.WARNING);
        }
        
    }

    
    
       
 private byte[] convertirArchivoABytes(File file) {
    try (InputStream inputStream = new java.io.FileInputStream(file)) {
        byte[] buffer = new byte[(int) file.length()];
        inputStream.read(buffer);
        return buffer;
    } catch (IOException e) {
        e.printStackTrace();
        Utilidades.mostrarNotificacion("Error", "No se pudo leer el archivo.", Alert.AlertType.ERROR);
        return null;
    }
}


    
private void guardarImagen(int idColaborador, File fotografia) {
    try {
        // Leer los bytes directamente del archivo de la imagen
        byte[] imagenBytes = Files.readAllBytes(fotografia.toPath());
        // Enviar los bytes al DAO
        Mensaje mensaje = ColaboradorDAO.cargarImagen(idColaborador, imagenBytes);

        if (!mensaje.isError()) {
            Utilidades.mostrarNotificacion("Éxito", "La imagen se guardó correctamente.", Alert.AlertType.INFORMATION);
        } else {
            Utilidades.mostrarNotificacion("Error", "No se pudo guardar la imagen: " + mensaje.getMensaje(), Alert.AlertType.ERROR);
        }
    } catch (IOException e) {
        Utilidades.mostrarNotificacion("Error", "No se pudo leer el archivo de imagen.", Alert.AlertType.ERROR);
    }
}




private Image visualizarImagen(int idColaborador) {
    try {
        byte[] imagenBytes = ColaboradorDAO.descargarImagen(idColaborador);
        if (imagenBytes != null && imagenBytes.length > 0) {
            InputStream inputStream = new ByteArrayInputStream(imagenBytes);
            return new Image(inputStream); // Crear imagen desde InputStream
        } else {
            Utilidades.mostrarNotificacion("Sin imagen", "No se encontró una imagen para este colaborador.", Alert.AlertType.WARNING);
        }
    } catch (Exception e) {
        e.printStackTrace();
        Utilidades.mostrarNotificacion("Error", "No se pudo visualizar la imagen.", Alert.AlertType.ERROR);
    }
    return null;
}

private void agregarColumnaFotografia() {
    TableColumn<Colaborador, Void> colFotografia = new TableColumn<>("Acciones");

    colFotografia.setCellFactory(param -> new TableCell<Colaborador, Void>() {
        private final Button btnGuardar = new Button("Guardar");
        private final Button btnVisualizar = new Button("Visualizar");
        private final HBox hBox = new HBox(5, btnGuardar, btnVisualizar);

        {
            // Configuración inicial de los botones
            hBox.setStyle("-fx-alignment: center;"); // Centra los botones en la celda
            btnGuardar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"); // Estilo del botón Guardar
            btnVisualizar.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;"); // Estilo del botón Visualizar

            // Acción del botón "Guardar"
            btnGuardar.setOnAction(event -> {
                Colaborador colaborador = getTableView().getItems().get(getIndex());
                if (colaborador != null) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"));
                    File archivoSeleccionado = fileChooser.showOpenDialog(null);

                    if (archivoSeleccionado != null) {
                        guardarImagen(colaborador.getIdColaborador(), archivoSeleccionado);
                        Utilidades.mostrarNotificacion("Éxito", "Imagen guardada correctamente.", Alert.AlertType.INFORMATION);
                    }
                }
            });

            // Acción del botón "Visualizar"
            btnVisualizar.setOnAction(event -> {
                Colaborador colaborador = getTableView().getItems().get(getIndex());
                if (colaborador != null) {
                    Image imagen = visualizarImagen(colaborador.getIdColaborador());
                    if (imagen != null) {
                        mostrarImagenEnVentana(imagen, colaborador.getNombre());
                    } else {
                        Utilidades.mostrarNotificacion("Sin imagen", "No hay una imagen asociada a este colaborador.", Alert.AlertType.WARNING);
                    }
                }
            });
        }

        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || getIndex() >= getTableView().getItems().size()) {
                setGraphic(null); // Limpia la celda si está vacía
            } else {
                setGraphic(hBox); // Muestra los botones en la celda
            }
        }
    });

    // Agregar la columna al TableView
    tvColaborador.getColumns().add(colFotografia);
}


private void mostrarImagenEnVentana(Image imagen, String nombreColaborador) {
    ImageView imageView = new ImageView(imagen);
    imageView.setFitWidth(400);
    imageView.setPreserveRatio(true);

    VBox vbox = new VBox(imageView);
    vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

    Stage stage = new Stage();
    stage.setTitle("Fotografía de " + nombreColaborador);
    stage.setScene(new Scene(vbox, 450, 450));
    stage.show();
}
}
