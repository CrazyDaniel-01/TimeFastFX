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
    private ObservableList<Colaborador> colaboradores;
    private ObservableList<Cliente> clientes;
    private ObservableList<Envio> envios;
    private ObservableList<Paquete> paquetes;

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
<<<<<<< Updated upstream
    @FXML
    private ImageView imgBuscar;
  
=======

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
   
=======
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
>>>>>>> Stashed changes

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarDatos();
    }

    @FXML
    public void panelClientes(ActionEvent actionEvent) {
        pnlClientes.toFront();

    }

    @FXML
    public void panelEnvios(ActionEvent actionEvent) {
        pnlEnvios.toFront();
    }

    @FXML
    public void panelPaquetes(ActionEvent actionEvent) {
        pnlPaquetes.toFront();
    }

    @FXML
    public void panelUnidades(ActionEvent actionEvent) {
        pnlUnidades.toFront();
    }

    @FXML
    public void panelColaboradores(ActionEvent actionEvent) {
        pnlColaboradores.toFront();
    }

    @Override
    public void notificarOperacion(String tipo, String nombre) {
<<<<<<< Updated upstream
        System.out.println("Tipo operacion: "+tipo);
        System.out.println("Nombre Colaborador: "+nombre);
        cargarDatos();
        
=======
        System.out.println("Tipo operacion: " + tipo);
        System.out.println("Nombre Colaborador: " + nombre);
        recargarTablaColaboradores();
        recargarTablaUnidades();
        recargarTablaClientes();
        recargarTablaPaquetes();
        recargarTablaEnvio();

    }

    private void cargarDatos() {
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

    @FXML
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

    @FXML
    public void buscarUnidad() {
        String nombreUnidadBuscada = buscaUnidad.getText().trim();
        List<Unidad> resultados = UnidadDAO.buscarUnidadesPorMarca(nombreUnidadBuscada);
        unidades.clear();
        if (resultados != null && !resultados.isEmpty()) {
            unidades.addAll(resultados);
            tvUnidad.setItems(unidades);
        } else {
            System.out.println("No se encontraron unidades con ese nombre.");
        }
    }

    private void irFormularioColaborador(NotificadorOperaciones observador, Colaborador colaborador) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FormularioColaboradorFXML.fxml"));

            Parent root = loader.load();

            FormularioColaboradorFXMLController controlador = loader.getController();
            controlador.inicializarValores(observador, colaborador);

            Stage escenarioForm = new Stage();
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
>>>>>>> Stashed changes
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

    @FXML
    private void btnAgregarUnidad(ActionEvent event) {
<<<<<<< Updated upstream
=======
        irFormularioUnidad(this, null);
>>>>>>> Stashed changes
    }

    @FXML
    private void btnEditarUnidad(ActionEvent event) {
    }

    @FXML
    private void btnEliminarUnidad(ActionEvent event) {
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
<<<<<<< Updated upstream
=======
        irFormularioCliente(this, null);
>>>>>>> Stashed changes
    }

    @FXML
    private void btnEditarCliente(ActionEvent event) {
    }

    @FXML
    private void btnEliminarCliente(ActionEvent event) {
    }

    @FXML
    private void btnAgregarColaborador(ActionEvent event) {
<<<<<<< Updated upstream
=======
        irFormularioColaborador(this, null);
>>>>>>> Stashed changes
    }

    @FXML
    private void btnEditarColaborador(ActionEvent event) {
<<<<<<< Updated upstream
=======

        Colaborador colaborador = tvColaborador.getSelectionModel().getSelectedItem();
        if (colaborador != null) {
            irFormularioColaborador(this, colaborador);

        } else {
            Utilidades.mostrarNotificacion("Seleccionar colaborador", "Para editar seleccione primero un colaborador ", Alert.AlertType.WARNING);
        }
>>>>>>> Stashed changes
    }

    @FXML
    private void btnEliminarColaborador(ActionEvent event) {
<<<<<<< Updated upstream
    }
=======
        Colaborador colaborador = tvColaborador.getSelectionModel().getSelectedItem();
        if (colaborador != null) {
            eliminarColaborador(colaborador.getIdColaborador());
        } else {
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
                notificarOperacion("eliminar", "colaborador");
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


>>>>>>> Stashed changes
    private void configurarTabla() {
        // Colaboradores
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidoP.setCellValueFactory(new PropertyValueFactory<>("apellidoPaterno"));
        colApellidoM.setCellValueFactory(new PropertyValueFactory<>("apellidoMaterno"));
        colCURP.setCellValueFactory(new PropertyValueFactory<>("curp"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
<<<<<<< Updated upstream
=======
        colLicencia.setCellValueFactory(new PropertyValueFactory<>("NumeroLicencia"));
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
    
    private void cargarDatos() {
=======
    }

    private void cargarDatosColaborador() {
>>>>>>> Stashed changes
        // Cargar datos para colaboradores
        colaboradores = FXCollections.observableArrayList();
        List<Colaborador> listaColaboradores = ColaboradorDAO.obtenerColaborador();
        if (listaColaboradores != null) {
            colaboradores.addAll(listaColaboradores);
            tvColaborador.setItems(colaboradores);
        } else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de colaboradores.", Alert.AlertType.ERROR);
        }
<<<<<<< Updated upstream

        // Cargar datos para otros paneles (Clientes, Unidades, etc.) según sea necesario
        // Ejemplo:
=======
    }

    private void cargarDatosCliente() {
>>>>>>> Stashed changes
        clientes = FXCollections.observableArrayList();
        List<Cliente> listaClientes = ClienteDAO.obtenerCliente();
        if (listaClientes != null) {
            clientes.addAll(listaClientes);
            tvCliente.setItems(clientes);
        } else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de cliente.", Alert.AlertType.ERROR);
        }
<<<<<<< Updated upstream
        
=======
    }

    private void cargarDatosUnidad() {
>>>>>>> Stashed changes
        //cargar datos Unidad
        unidades = FXCollections.observableArrayList();
        List<Unidad> listaUnidad = UnidadDAO.obtenerUnidad();
        if (listaUnidad != null) {
            unidades.addAll(listaUnidad);
            tvUnidad.setItems(unidades);
        } else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de unidad.", Alert.AlertType.ERROR);
        }
<<<<<<< Updated upstream
        
=======
    }

    public void cargarDatosEnvio() {
>>>>>>> Stashed changes
        //cargar datos Envio
        envios = FXCollections.observableArrayList();
        List<Envio> listaEnvio = EnvioDAO.obtenerEnvio();
        if (listaEnvio != null) {
            envios.addAll(listaEnvio);
            tvEnvios.setItems(envios);
        } else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de envio.", Alert.AlertType.ERROR);
        }
<<<<<<< Updated upstream
        
        //cargar datos Paquete
=======
    }

    public void cargarDatosPaquete() {
>>>>>>> Stashed changes
        paquetes = FXCollections.observableArrayList();
        List<Paquete> listaPaquete = PaqueteDAO.obtenerPaquete();
        if (listaPaquete != null) {
            paquetes.addAll(listaPaquete);
            tvPaquetes.setItems(paquetes);
        } else {
            Utilidades.mostrarNotificacion("Error", "No se pudo cargar la información de paquetes.", Alert.AlertType.ERROR);
        }
    }

<<<<<<< Updated upstream
    
    
=======
>>>>>>> Stashed changes
}
