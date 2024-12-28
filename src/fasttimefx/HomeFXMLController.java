/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
    private ImageView imgBuscar;
  
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
    private TableColumn colFoto;
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
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarDatos();
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
        System.out.println("Tipo operacion: "+tipo);
        System.out.println("Nombre Colaborador: "+nombre);
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
            System.out.println("No se encontraron colaboradores con ese nombre.");
        }
    }
    public void buscarCliente() {
        String nombreClienteBuscado = buscaCliente.getText().trim();
        List<Cliente> resultados = ClienteDAO.buscarClientesPorNombre(nombreClienteBuscado);
        clientes.clear();
        if (resultados != null && !resultados.isEmpty()) {
            clientes.addAll(resultados);
            tvCliente.setItems(clientes);
        } else {
            System.out.println("No se encontraron colaboradores con ese nombre.");
        }
    }
    
    private void irFormularioColaborador(NotificadorOperaciones observador, Colaborador colaborador){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioColaboradorFXML.fxml"));
            
            Parent root= loader.load();
            //
            FormularioColaboradorFXMLController controlador = loader.getController();
            controlador.inicializarValores(observador, colaborador);
            //
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
    @FXML
    private void btnAgregarUnidad(ActionEvent event) {
    }

    @FXML
    private void btnEditarUnidad(ActionEvent event) {
    }

    @FXML
    private void btnEliminarUnidad(ActionEvent event) {
    }

    @FXML
    private void btnAgregarEnvio(ActionEvent event) {
    }

    @FXML
    private void btnEditarEnvio(ActionEvent event) {
    }

    @FXML
    private void btnEliminarEnvio(ActionEvent event) {
    }

    @FXML
    private void btnAgregarPaquete(ActionEvent event) {
    }

    @FXML
    private void btnEditarPaqute(ActionEvent event) {
    }

    @FXML
    private void btnEliminarPaquete(ActionEvent event) {
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
        System.out.print("Esto es un boton de eliminar");
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
    
    
    private void configurarTabla() {
        // Colaboradores
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        colApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
        colCURP.setCellValueFactory(new PropertyValueFactory<>("curp"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        colLicencia.setCellValueFactory(new PropertyValueFactory<>("NumeroLicencia"));


        // Unidades
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoUnidad"));
        colAño.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colVIN.setCellValueFactory(new PropertyValueFactory<>("vin"));
        colNumeroIn.setCellValueFactory(new PropertyValueFactory<>("idInterno"));

        // Envios
        colEnvio.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colOrigen.setCellValueFactory(new PropertyValueFactory<>("origen"));
        colGuia.setCellValueFactory(new PropertyValueFactory<>("noGuia"));
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
        colFoto.setCellValueFactory(new PropertyValueFactory<>("fotoBase64"));
    
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
    
    
    
}
