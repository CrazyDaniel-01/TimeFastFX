package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.ClienteDAO;
import fasttimefx.dao.EnvioDAO;
import fasttimefx.pojo.Cliente;
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Mensaje;
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

public class FormularioEnvioFXMLController implements Initializable {

    private NotificadorOperaciones observador;
    private Envio envioEdicion;
    private boolean modoEdicion = false;
    
    private ObservableList<Cliente> cliente;

    @FXML
    private ComboBox<Cliente> cbCliente;
    @FXML
    private TextField tfCalleOrigen;
    @FXML
    private TextField tfNumeroOrigen;
    @FXML
    private TextField tfColoniaOrigen;
    @FXML
    private TextField tfCPOrigen;
    @FXML
    private TextField tfCuidadOrigen;
    @FXML
    private TextField tfEstadoOrigen;
    @FXML
    private TextField tfCalleDestino;
    @FXML
    private TextField tfNumeroDestino;
    @FXML
    private TextField tfColoniaDestino;
    @FXML
    private TextField tfCPDestino;
    @FXML
    private TextField tfCuidadDestino;
    @FXML
    private TextField tfEstadoDestino;
    @FXML
    private Button btnGuardarEnvio;
    @FXML
    private Label errorCliente;
    @FXML
    private Label errorCosto;
    @FXML
    private Label errorCalleOrigen;
    @FXML
    private Label errorNumeroOrigen;
    @FXML
    private Label errorColoniaOrigen;
    @FXML
    private Label errorCPOrigen;
    @FXML
    private Label errorCiudadOrigen;
    @FXML
    private Label errorEstadoOrigen;
    @FXML
    private Label errorCalleDestino;
    @FXML
    private Label errorNumeroDestino;
    @FXML
    private Label errorColoniaDestino;
    @FXML
    private Label errorCPDestino;
    @FXML
    private Label errorCiudadDestino;
    @FXML
    private Label errorEstadoDestino;
    @FXML
    private TextField tfCosto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarDatosCliente();
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
    private void ClickBotonGuardar(ActionEvent event) {
        if (validarCampos()) {
            Envio envio = new Envio();
            if (!modoEdicion) {
                    Integer idCliente = ((cbCliente.getSelectionModel().getSelectedItem() != null)
        ? cbCliente.getSelectionModel().getSelectedItem().getIdCliente()
        : null);
    envio.setIdCliente(idCliente);
    

    envio.setCalleOrigen(tfCalleOrigen.getText());
    envio.setCalleDestino(tfCalleDestino.getText());
    envio.setNumeroDestino(Integer.parseInt(tfNumeroDestino.getText()));
    envio.setNumeroOrigen(Integer.parseInt(tfNumeroOrigen.getText()));
    envio.setCiudadDestino(tfCuidadDestino.getText());
    envio.setCiudadOrigen(tfCuidadOrigen.getText());
    envio.setCodigoPostalDestino(Integer.parseInt(tfCPDestino.getText()));
    envio.setCodigoPostalOrigen(Integer.parseInt(tfCPOrigen.getText()));
    envio.setColoniaDestino(tfColoniaDestino.getText());
    envio.setColoniaOrigen(tfColoniaOrigen.getText());
    envio.setEstadoDestino(tfEstadoDestino.getText());
    envio.setEstadoOrigen(tfEstadoOrigen.getText());
    envio.setCosto(tfCosto.getText());
    guardarDatosEnvio(envio);

            } else {
                   envio.setCalleOrigen(tfCalleOrigen.getText());
    envio.setCalleDestino(tfCalleDestino.getText());
    envio.setNumeroDestino(Integer.parseInt(tfNumeroDestino.getText()));
    envio.setNumeroOrigen(Integer.parseInt(tfNumeroOrigen.getText()));
    envio.setCiudadDestino(tfCuidadDestino.getText());
    envio.setCiudadOrigen(tfCuidadOrigen.getText());
    envio.setCodigoPostalDestino(Integer.parseInt(tfCPDestino.getText()));
    envio.setCodigoPostalOrigen(Integer.parseInt(tfCPOrigen.getText()));
    envio.setColoniaDestino(tfColoniaDestino.getText());
    envio.setColoniaOrigen(tfColoniaOrigen.getText());
    envio.setEstadoDestino(tfEstadoDestino.getText());
    envio.setEstadoOrigen(tfEstadoOrigen.getText());
    envio.setIdCliente(cbCliente.getSelectionModel().getSelectedIndex()+1);
    envio.setCosto(tfCosto.getText());
    envio.setIdOrigen(this.envioEdicion.getIdOrigen());
    envio.setIdDestino(this.envioEdicion.getIdDestino());
    envio.setIdEnvio(this.envioEdicion.getIdEnvio());
                setDatosEnvio(envio);
                Integer idCliente = (cbCliente.getSelectionModel().getSelectedItem() != null)
                        ? cbCliente.getSelectionModel().getSelectedItem().getIdCliente()
                        : null;
                envio.setIdCliente(idCliente);
                editarDatosEnvio(envio);
            }
        }
    }

  private void cargarDatosEdicion() {
      desglosarDireccionOrigen(this.envioEdicion.getOrigen());
      desglosarDireccionDestino(this.envioEdicion.getDestino());

        tfCosto.setText(this.envioEdicion.getCosto() != null ? envioEdicion.getCosto() : "");
    
}

private void desglosarDireccionOrigen(String direccion){
    String[] partes = direccion.split(",\\s*");  
    if (partes.length == 6) {
        String calle = partes[0];
        String numero = partes[1];
        String colonia = partes[2];
        String codigoPostal = partes[3];
        String ciudad = partes[4];
        String estado= partes[5];
        tfCalleOrigen.setText(calle);
        tfNumeroOrigen.setText(numero);
        tfColoniaOrigen.setText(colonia);
        tfCPOrigen.setText(codigoPostal);
        tfCuidadOrigen.setText(ciudad);
        tfEstadoOrigen.setText(estado);
    } else {
        System.out.println("Dirección de origen mal formateada");
    }
}
private void desglosarDireccionDestino(String direccion){
    String[] partes = direccion.split(",\\s*");  
    if (partes.length == 6) {
        String calle = partes[0];
        String numero = partes[1];
        String colonia = partes[2];
        String codigoPostal = partes[3];
        String ciudad = partes[4];
        String estado= partes[5];
        tfCalleDestino.setText(calle);
        tfNumeroDestino.setText(numero);
        tfColoniaDestino.setText(colonia);
        tfCPDestino.setText(codigoPostal);
        tfCuidadDestino.setText(ciudad);
        tfEstadoDestino.setText(estado);
    } else {
        System.out.println("Dirección de origen mal formateada");
    }
}
        
private boolean validarCampos() {
    boolean camposValidos = true;
        if (tfCalleOrigen.getText().isEmpty()) {
            camposValidos = false;
            errorCalleOrigen.setText("Por favor ingrese una calle");
        } else {
            errorCalleOrigen.setText("");
        } if (tfNumeroOrigen.getText().isEmpty()) {
            camposValidos = false;
            errorNumeroOrigen.setText("Por favor ingrese un número");
        } else if (!esNumeroValido(tfNumeroOrigen.getText())) {
            camposValidos = false;
            errorNumeroOrigen.setText("El número debe ser mayor a 0");
        } else {
            errorNumeroOrigen.setText("");
        }if (tfColoniaOrigen.getText().isEmpty()) {
            camposValidos = false;
            errorColoniaOrigen.setText("Por favor ingrese una colonia");
        } else {
            errorColoniaOrigen.setText("");
        }if (tfCPOrigen.getText().isEmpty()) {
            camposValidos = false;
            errorCPOrigen.setText("Por favor ingrese un código postal");
        } else if (!esCodigoPostalValido(tfCPOrigen.getText())) {
            camposValidos = false;
            errorCPOrigen.setText("El código postal debe ser un número válido");
        } else {
            errorCPOrigen.setText("");
        }if (tfCuidadOrigen.getText().isEmpty()) {
            camposValidos = false;
            errorCiudadOrigen.setText("Por favor ingrese una ciudad");
        } else {
            errorCiudadOrigen.setText("");
        }if (tfEstadoOrigen.getText().isEmpty()) {
            camposValidos = false;
            errorEstadoOrigen.setText("Por favor ingrese un estado");
        } else {
            errorEstadoOrigen.setText("");
        }if (tfCalleDestino.getText().isEmpty()) {
            camposValidos = false;
            errorCalleDestino.setText("Por favor ingrese una calle de destino");
        } else {
            errorCalleDestino.setText("");
        }if (tfNumeroDestino.getText().isEmpty()) {
            camposValidos = false;
            errorNumeroDestino.setText("Por favor ingrese un número de destino");
        } else if (!esNumeroValido(tfNumeroDestino.getText())) {
            camposValidos = false;
            errorNumeroDestino.setText("El número de destino debe ser mayor a 0");
        } else {
            errorNumeroDestino.setText("");
        }if (tfColoniaDestino.getText().isEmpty()) {
            camposValidos = false;
            errorColoniaDestino.setText("Por favor ingrese una colonia de destino");
        } else {
            errorColoniaDestino.setText("");
        }if (tfCPDestino.getText().isEmpty()) {
            camposValidos = false;
            errorCPDestino.setText("Por favor ingrese un código postal de destino");
        } else if (!esCodigoPostalValido(tfCPDestino.getText())) {
            camposValidos = false;
            errorCPDestino.setText("El código postal de destino debe ser un número válido");
        } else {
            errorCPDestino.setText("");
        }if (tfCuidadDestino.getText().isEmpty()) {
            camposValidos = false;
            errorCiudadDestino.setText("Por favor ingrese una ciudad de destino");
        } else {
            errorCiudadDestino.setText("");
        }if (tfEstadoDestino.getText().isEmpty()) {
            camposValidos = false;
            errorEstadoDestino.setText("Por favor ingrese un estado de destino");
        } else {
            errorEstadoDestino.setText("");
        }if(tfCosto.getText().isEmpty()){
            camposValidos=false;
            errorCosto.setText("Por favor ingrese un costo de envio");
        }else{
            errorCosto.setText("");
        }

        return camposValidos;
    }

// Verifica si un número es válido (mayor a 0 y es un entero)
private boolean esNumeroValido(String numero) {
    try {
        int num = Integer.parseInt(numero);
        return num > 0;
    } catch (NumberFormatException e) {
        return false;
    }
}

private boolean esCodigoPostalValido(String codigoPostal) {
    return codigoPostal.matches("\\d{5}");
}

    private void setDatosEnvio(Envio envio) {
        envio.setCalleOrigen(tfCalleOrigen.getText());
        envio.setCalleDestino(tfCalleDestino.getText());
        envio.setNumeroDestino(Integer.parseInt(tfNumeroDestino.getText()));
        envio.setNumeroOrigen(Integer.parseInt(tfNumeroOrigen.getText()));
        envio.setCiudadDestino(tfCuidadDestino.getText());
        envio.setCiudadOrigen(tfCuidadOrigen.getText());
        envio.setCodigoPostalDestino(Integer.parseInt(tfCPDestino.getText()));
        envio.setCodigoPostalOrigen(Integer.parseInt(tfCPOrigen.getText()));
        envio.setColoniaDestino(tfColoniaDestino.getText());
        envio.setColoniaOrigen(tfColoniaOrigen.getText());
        envio.setEstadoDestino(tfEstadoDestino.getText());
        envio.setEstadoOrigen(tfEstadoOrigen.getText());
        envio.setCosto(tfCosto.getText());
    }

    private void guardarDatosEnvio(Envio envio) {
        Mensaje msj = EnvioDAO.registrarEnvio(envio);

        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Registro exitoso",
                    "El envío fue registrado exitosamente.",
                    Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Nuevo Registro", envio.getCalleOrigen());
        } else {
            Utilidades.mostrarNotificacion("Error al guardar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    private void editarDatosEnvio(Envio envio) {
    Mensaje msj = EnvioDAO.actualizarEnvio(envio);

    if (!msj.isError()) {
        Utilidades.mostrarNotificacion("Actualización exitosa",
                "El envío fue actualizado exitosamente.",
                Alert.AlertType.INFORMATION);
        cerrarVentana();
        observador.notificarOperacion("Edición", envio.getCalleOrigen());
    } else {
        Utilidades.mostrarNotificacion("Error al actualizar", msj.getMensaje(), Alert.AlertType.ERROR);
    }
}

    public void cargarDatosCliente() {
        cliente = FXCollections.observableArrayList();
        List<Cliente> listaWS = ClienteDAO.obtenerCliente();

        if (listaWS != null && !listaWS.isEmpty()) {
            cliente.addAll(listaWS);
            cbCliente.setItems(cliente);
        } else {
            Utilidades.mostrarNotificacion("Error al cargar",
                    "No se pudieron cargar los clientes. Por favor, inténtelo más tarde.",
                    Alert.AlertType.ERROR);
            cbCliente.setDisable(true);
        }
    }

private int buscarIdCliente(int idCliente) {
    if (cliente != null) {
        for (int i = 0; i < cliente.size(); i++) {
            if (cliente.get(i).getIdCliente() == idCliente) {
                return i;
            }
        }
    }
    System.err.println("Cliente con ID " + idCliente + " no encontrado.");
    return -1;
}


    private void cerrarVentana() {
        Stage base = (Stage) tfCalleOrigen.getScene().getWindow();
        base.close();
    }
}
