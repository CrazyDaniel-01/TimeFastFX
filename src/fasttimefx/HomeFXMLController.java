/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.ClienteDAO;
import fasttimefx.dao.ColaboradorDAO;
import fasttimefx.dao.EnvioDAO;
import fasttimefx.dao.PaqueteDAO;
import fasttimefx.dao.UnidadDAO;
import fasttimefx.pojo.Cliente;
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Paquete;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
        cargarDatos();
        
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
    }

    @FXML
    private void btnEditarCliente(ActionEvent event) {
    }

    @FXML
    private void btnEliminarCliente(ActionEvent event) {
    }

    @FXML
    private void btnAgregarColaborador(ActionEvent event) {
    }

    @FXML
    private void btnEditarColaborador(ActionEvent event) {
    }

    @FXML
    private void btnEliminarColaborador(ActionEvent event) {
    }
    private void configurarTabla() {
        // Colaboradores
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        colApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
        colCURP.setCellValueFactory(new PropertyValueFactory<>("curp"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));

        // Unidades
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colAño.setCellValueFactory(new PropertyValueFactory<>("año"));
        colVIN.setCellValueFactory(new PropertyValueFactory<>("vin"));
        colNumeroIn.setCellValueFactory(new PropertyValueFactory<>("numeroInventario"));

        // Envios
        colEnvio.setCellValueFactory(new PropertyValueFactory<>("idEnvio"));
        colOrigen.setCellValueFactory(new PropertyValueFactory<>("origen"));
        colGuia.setCellValueFactory(new PropertyValueFactory<>("numeroGuia"));
        colDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
        colCosto.setCellValueFactory(new PropertyValueFactory<>("costo"));
        colConductor.setCellValueFactory(new PropertyValueFactory<>("nombreConductor"));

        // Paquetes
        colNumeroGP.setCellValueFactory(new PropertyValueFactory<>("numeroPaquete"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
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

    
    private void cargarDatos() {
        // Cargar datos para colaboradores
        colaboradores = FXCollections.observableArrayList();
        List<Colaborador> listaColaboradores = ColaboradorDAO.obtenerColaborador();
        if (listaColaboradores != null) {
            colaboradores.addAll(listaColaboradores);
            tvColaborador.setItems(colaboradores);
        } else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de colaboradores.", Alert.AlertType.ERROR);
        }

        // Cargar datos para otros paneles (Clientes, Unidades, etc.) según sea necesario
        // Ejemplo:
        clientes = FXCollections.observableArrayList();
        List<Cliente> listaClientes = ClienteDAO.obtenerCliente();
        if (listaClientes != null) {
            clientes.addAll(listaClientes);
            tvCliente.setItems(clientes);
        }else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de cliente.", Alert.AlertType.ERROR);
        }
        
        //cargar datos Unidad
        unidades = FXCollections.observableArrayList();
        List<Unidad> listaUnidad = UnidadDAO.obtenerUnidad();
        if (listaUnidad != null) {
            unidades.addAll(listaUnidad);
            tvUnidad.setItems(unidades);
        }else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de unidad.", Alert.AlertType.ERROR);
        }
        
        //cargar datos Envio
        envios = FXCollections.observableArrayList();
        List<Envio> listaEnvio = EnvioDAO.obtenerEnvio();
        if (listaEnvio != null) {
            envios.addAll(listaEnvio);
            tvEnvios.setItems(envios);
        }else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de envio.", Alert.AlertType.ERROR);
        }
        
        //cargar datos Paquete
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
