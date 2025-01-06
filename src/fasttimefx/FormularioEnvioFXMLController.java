package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.ClienteDAO;
import fasttimefx.dao.EnvioDAO;
import fasttimefx.pojo.Cliente;
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Mensaje;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import observador.NotificadorOperaciones;

public class FormularioEnvioFXMLController implements Initializable {

    private NotificadorOperaciones observador;
    private Envio envioEdicion;
    private boolean modoEdicion = false;
    private ObservableList<Cliente> cliente;

    @FXML
    private TextField tfCalleOrigen;
    @FXML
    private TextField tfColoniaOrigen;
    @FXML
    private TextField tfNumeroOrigen;
    @FXML
    private TextField tfCPOrigen;
    @FXML
    private TextField tfEstadoOrigen;
    @FXML
    private TextField tfCiudadOrigen;
    @FXML
    private TextField tfCalleDestino;
    @FXML
    private TextField tfColoniaDestino;
    @FXML
    private TextField tfNumeroDestino;
    @FXML
    private TextField tfCPDestino;
    @FXML
    private TextField tfEstadoDestino;
    @FXML
    private TextField tfCiudadDestino;
    @FXML
    private TextField tfNumeroGuia;
    @FXML
    private TextField tfCosto;
    @FXML
    private ComboBox<Cliente> cbCliente;
    @FXML
    private TextField tfCuidadOrigen;
    @FXML
    private TextField tfEstado;
    @FXML
    private TextField tfCuidadDestino;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTiposClientes();
    }

    public void inicializarValores(NotificadorOperaciones observador, Envio envioEdicion) {
        this.observador = observador;
        this.envioEdicion = envioEdicion;
        if (envioEdicion != null) {
            modoEdicion = true;
            cargarDatosEdicion();
        }
    }

    @FXML
    public void clicGuardarEnvio(ActionEvent event) {
        if (validarCampos()) {
            try {
                Envio envio = new Envio();

                envio.setCalleOrigen(tfCalleOrigen.getText());
                envio.setColoniaOrigen(tfColoniaOrigen.getText());
                envio.setNumeroOrigen(Integer.parseInt(tfNumeroOrigen.getText()));
                envio.setCodigoPostalOrigen(Integer.parseInt(tfCPOrigen.getText()));
                envio.setEstadoOrigen(tfEstadoOrigen.getText());
                envio.setCiudadOrigen(tfCiudadOrigen.getText());
                envio.setCalleDestino(tfCalleDestino.getText());
                envio.setColoniaDestino(tfColoniaDestino.getText());
                envio.setNumeroDestino(Integer.parseInt(tfNumeroDestino.getText()));
                envio.setCodigoPostalDestino(Integer.parseInt(tfCPDestino.getText()));
                envio.setEstadoDestino(tfEstadoDestino.getText());
                envio.setCiudadDestino(tfCiudadDestino.getText());
                envio.setNoGuia(tfNumeroGuia.getText());
                envio.setCosto(tfCosto.getText());

                if (modoEdicion) {
                    envio.setIdEnvio(this.envioEdicion.getIdEnvio());
                    editarDatosEnvio(envio);
                } else {
                    guardarDatosEnvio(envio);
                }
            } catch (NumberFormatException e) {
                Utilidades.mostrarNotificacion("Error de formato", "Asegúrese de ingresar números válidos en los campos correspondientes.", Alert.AlertType.ERROR);
            }
        }
    }

    private boolean validarCampos() {
   
        return true;
    }

    private void guardarDatosEnvio(Envio envio) {
        Mensaje msj = EnvioDAO.registrarEnvio(envio);
        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Registro exitoso", "El envío fue registrado exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Nuevo Envío", envio.getNoGuia());
        } else {
            Utilidades.mostrarNotificacion("Error al guardar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    private void editarDatosEnvio(Envio envio) {
        Mensaje msj = EnvioDAO.actualizarEnvio(envio);
        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Actualización exitosa", "El envío fue actualizado exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Edición de Envío", envio.getNoGuia());
        } else {
            Utilidades.mostrarNotificacion("Error al actualizar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    private void cargarDatosEdicion() {
        tfCalleOrigen.setText(envioEdicion.getCalleOrigen());
        tfColoniaOrigen.setText(envioEdicion.getColoniaOrigen());
        tfNumeroOrigen.setText(String.valueOf(envioEdicion.getNumeroOrigen()));
        tfCPOrigen.setText(String.valueOf(envioEdicion.getCodigoPostalOrigen()));
        tfEstadoOrigen.setText(envioEdicion.getEstadoOrigen());
        tfCiudadOrigen.setText(envioEdicion.getCiudadOrigen());
        tfCalleDestino.setText(envioEdicion.getCalleDestino());
        tfColoniaDestino.setText(envioEdicion.getColoniaDestino());
        tfNumeroDestino.setText(String.valueOf(envioEdicion.getNumeroDestino()));
        tfCPDestino.setText(String.valueOf(envioEdicion.getCodigoPostalDestino()));
        tfEstadoDestino.setText(envioEdicion.getEstadoDestino());
        tfCiudadDestino.setText(envioEdicion.getCiudadDestino());
        tfNumeroGuia.setText(envioEdicion.getNoGuia());
        tfCosto.setText(envioEdicion.getCosto());
        int posicion = buscarIdCliente(this.envioEdicion.getIdCliente());
        cbCliente.getSelectionModel().select(posicion);
    }

    private void cerrarVentana() {
        Stage base = (Stage) tfCalleOrigen.getScene().getWindow();
        base.close();
    }

    private void cargarTiposClientes() {
        cliente = FXCollections.observableArrayList();
        List<Cliente> listaWS = ClienteDAO.obtenerCliente();
        if (listaWS != null && !listaWS.isEmpty()) {
            cliente.addAll(listaWS);
            cbCliente.setItems(cliente);
        } else {
            Utilidades.mostrarNotificacion("ERROR AL CARGAR", "No se pudieron cargar los clientes. Inténtelo más tarde.", Alert.AlertType.ERROR);
        }
    }

    private int buscarIdCliente(int idCliente) {
        for (int i = 0; i < cliente.size(); i++) {
            if (cliente.get(i).getIdCliente() == idCliente)
                return i;
        }
        return 0;
    }
 

}
