package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.ClienteDAO;
import fasttimefx.pojo.Cliente;
import fasttimefx.pojo.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import observador.NotificadorOperaciones;

public class FormularioClienteFXMLController implements Initializable {

    private NotificadorOperaciones observador;
    private Cliente clienteEdicion;
    private boolean modoEdicion = false;

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfApellidoMaterno;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfCalle;
    @FXML
    private TextField tfNumero;
    @FXML
    private TextField tfColonia;
    @FXML
    private TextField tfCodigoPostal;
    @FXML
    private Button btnGuardar;

    @FXML
    private Label errorNombre;
    @FXML
    private Label errorApellidoPaterno;
    @FXML
    private Label errorApellidoMaterno;
    @FXML
    private Label errorTelefono;
    @FXML
    private Label errorCorreo;
    @FXML
    private Label errorCalle;
    @FXML
    private Label errorNumero;
    @FXML
    private Label errorColonia;
    @FXML
    private Label errorCodigoPostal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void inicializarValores(NotificadorOperaciones observador, Cliente clienteEdicion) {
        this.observador = observador;
        this.clienteEdicion = clienteEdicion;
        if (clienteEdicion != null) {
            modoEdicion = true;
            cargarDatosEdicion();
        }
    }

    @FXML
    private void clicGuardarCliente(ActionEvent event) {
        if (validarCampos()) {
            Cliente cliente = new Cliente();
            if (!modoEdicion) {
                cliente.setNombre(tfNombre.getText());
                cliente.setApellidoPaterno(tfApellidoPaterno.getText());
                cliente.setApellidoMaterno(tfApellidoMaterno.getText());
                cliente.setTelefono(tfTelefono.getText());
                cliente.setCorreo(tfCorreo.getText());
                cliente.setCalle(tfCalle.getText());
                cliente.setNumero(tfNumero.getText());
                cliente.setColonia(tfColonia.getText());
                cliente.setCodigoPostal(tfCodigoPostal.getText());

                guardarDatosCliente(cliente);
            } else {
                cliente.setIdCliente(this.clienteEdicion.getIdCliente());
                cliente.setNombre(tfNombre.getText());
                cliente.setApellidoPaterno(tfApellidoPaterno.getText());
                cliente.setApellidoMaterno(tfApellidoMaterno.getText());
                cliente.setCorreo(tfCorreo.getText());
                cliente.setTelefono(tfTelefono.getText());
                cliente.setCalle(tfCalle.getText());
                cliente.setNumero(tfNumero.getText());
                cliente.setColonia(tfColonia.getText());
                cliente.setCodigoPostal(tfCodigoPostal.getText());
                cliente.setIdDireccion(this.clienteEdicion.getIdDireccion());

                editarDatosCliente(cliente);
            }
        }
    }

    private void cargarDatosEdicion() {
    String direccionCompleta =this.clienteEdicion.getDireccion();
    System.out.println(direccionCompleta);
    desglosarDireccion(direccionCompleta);
        tfNombre.setText(this.clienteEdicion.getNombre());
        tfApellidoPaterno.setText(this.clienteEdicion.getApellidoPaterno());
        tfApellidoMaterno.setText(this.clienteEdicion.getApellidoMaterno());
        tfTelefono.setText(this.clienteEdicion.getTelefono());
        tfCorreo.setText(this.clienteEdicion.getCorreo());
    }

    private void guardarDatosCliente(Cliente cliente) {
        Mensaje msj = ClienteDAO.registrarCliente(cliente);
        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Registro exitoso", "El cliente " + cliente.getNombre()
                    + " " + cliente.getApellidoPaterno() + " fue registrado exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Nuevo Registro", cliente.getNombre());
        } else {
            Utilidades.mostrarNotificacion("Error al guardar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    private void editarDatosCliente(Cliente cliente) {
        Mensaje msj = ClienteDAO.actualizarCliente(cliente);
        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Actualización exitosa", "El cliente " + cliente.getNombre()
                    + " " + cliente.getApellidoPaterno() + " fue actualizado exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Edición de Registro", cliente.getNombre());
        } else {
            Utilidades.mostrarNotificacion("Error al actualizar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    private void cerrarVentana() {
        Stage stage = (Stage) tfNombre.getScene().getWindow();
        stage.close();
    }

    private boolean validarCampos() {
        boolean validos = true;

        if (tfNombre.getText().isEmpty()) {
            validos = false;
            errorNombre.setText("El nombre es obligatorio.");
        } else {
            errorNombre.setText("");
        }

        if (tfApellidoPaterno.getText().isEmpty()) {
            validos = false;
            errorApellidoPaterno.setText("El apellido paterno es obligatorio.");
        } else {
            errorApellidoPaterno.setText("");
        }

        if (tfApellidoMaterno.getText().isEmpty()) {
            validos = false;
            errorApellidoMaterno.setText("El apellido materno es obligatorio.");
        } else {
            errorApellidoMaterno.setText("");
        }

        if (tfTelefono.getText().isEmpty() || !tfTelefono.getText().matches("\\d{10}")) {
            validos = false;
            errorTelefono.setText("El teléfono debe tener 10 dígitos.");
        } else {
            errorTelefono.setText("");
        }

        if (tfCorreo.getText().isEmpty() || !tfCorreo.getText().contains("@")) {
            validos = false;
            errorCorreo.setText("El correo debe ser válido.");
        } else {
            errorCorreo.setText("");
        }

        if (tfCalle.getText().isEmpty()) {
            validos = false;
            errorCalle.setText("La calle es obligatoria.");
        } else {
            errorCalle.setText("");
        }

        if (tfNumero.getText().isEmpty()) {
            validos = false;
            errorNumero.setText("El número es obligatorio.");
        } else {
            errorNumero.setText("");
        }

        if (tfColonia.getText().isEmpty()) {
            validos = false;
            errorColonia.setText("La colonia es obligatoria.");
        } else {
            errorColonia.setText("");
        }

        if (tfCodigoPostal.getText().isEmpty() || !tfCodigoPostal.getText().matches("\\d{5}")) {
            validos = false;
            errorCodigoPostal.setText("El código postal debe tener 5 dígitos.");
        } else {
            errorCodigoPostal.setText("");
        }

        return validos;
    }
    public void desglosarDireccion(String direccion) {
    String[] partes = direccion.split(",\\s*");  
    if (partes.length == 4) {
        String calle = partes[0];
        String numero = partes[1];
        String colonia = partes[2];
        String codigoPostal = partes[3];
        System.out.print(calle);
        System.out.print(numero);
        System.out.print(colonia);
        System.out.print(codigoPostal);
        tfCalle.setText(calle);
        tfNumero.setText(numero);
        tfColonia.setText(colonia);
        tfCodigoPostal.setText(codigoPostal);
    } else {
        System.out.println("Dirección mal formateada");
    }
}

}
