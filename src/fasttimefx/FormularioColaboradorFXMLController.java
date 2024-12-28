/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.ColaboradorDAO;
import fasttimefx.dao.RolDAO;
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.Rol;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import observador.NotificadorOperaciones;

/**
 * FXML Controller class
 *
 * @author afs30
 */
public class FormularioColaboradorFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private NotificadorOperaciones observador;
    private Colaborador colaboradorEedicion;
    private boolean modoEdicion = false;
    @FXML
    ObservableList<Rol> tiposColaboradores = RolDAO.obtenerRoles();
    
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfPaterno;
    @FXML
    private TextField tfMaterno;
    @FXML
    private TextField tfCURP;
    @FXML
    private TextField tfCorreo;
    @FXML
    private TextField tfContra;
    @FXML
    private TextField tfNoPersonal;
    @FXML
    private ComboBox<Rol> cbRol;
    @FXML
    private TextField tfNumLicencia;
    @FXML
    private Button btnAgregar;
    private TextField tfTelefono;
    @FXML
    private Label errorNombre;
    @FXML
    private Label errorPaterno;
    @FXML
    private Label errorMaterno;
    @FXML
    private Label errorCurp;
    @FXML
    private Label errorCorreo;
    @FXML
    private Label errorContra;
    @FXML
    private Label errorNoPersonal;
    @FXML
    private Label errorRol;
    @FXML
    private Label errorNumLicencia;
    @Override
public void initialize(URL url, ResourceBundle rb) {
    cargarTipoUsuarios();
}

private void cargarTipoUsuarios(){
    ObservableList<Rol> tiposColaboradores = FXCollections.observableArrayList();
    tiposColaboradores.add(new Rol(1, "Administrador"));
    tiposColaboradores.add(new Rol(2, "Conductor"));
    tiposColaboradores.add(new Rol(3, "Operador"));
    cbRol.setItems(tiposColaboradores);
}  
    public void inicializarValores(NotificadorOperaciones observador,Colaborador colaboradorEdicion){
        this.observador=observador;
        this.colaboradorEedicion=colaboradorEdicion;
        if(colaboradorEdicion!=null){
            modoEdicion=true;
            cargarDatosEdicion();
        }
    }
    
    private int buscarIdRol(int idRol){
        for (int i=0; i<tiposColaboradores.size();i++){
            if(tiposColaboradores.get(i).getIdRol()==idRol)
                return 1;
        }
        return 0;
    }
    @FXML
    public void clicGuardarColaborador(ActionEvent event){
        
        if(validarCampos()!=false){
            Colaborador colaborador = new Colaborador();
            if(!modoEdicion){
                String noPersonal=tfNoPersonal.getText();
                String nombre=tfNombre.getText();
                String apellidoPaterno=tfPaterno.getText();
                String apellidoMaterno=tfMaterno.getText();

                String password=tfContra.getText();
                String correo=tfCorreo.getText();
                String curp=tfCURP.getText();
                Integer rol=cbRol.getSelectionModel().getSelectedItem().getIdRol();
                if(rol==2){
                    String numeroLicencia=tfNumLicencia.getText();
                    colaborador.setNumeroLicencia(numeroLicencia);
                }
                colaborador.setNombre(nombre);
                colaborador.setApellidoMaterno(apellidoMaterno);
                colaborador.setApellidoPaterno(apellidoPaterno);
                colaborador.setNoPersonal(noPersonal);
                colaborador.setPassword(password);
                colaborador.setCorreo(correo);
                colaborador.setCurp(curp);
                colaborador.setIdRol(rol);
            
           guardarDatosColaborador(colaborador);
            }else{
                colaborador.setIdColaborador(this.colaboradorEedicion.getIdColaborador());
                colaborador.setNombre(tfNombre.getText());
                colaborador.setApellidoPaterno(tfPaterno.getText());
                colaborador.setApellidoMaterno(tfMaterno.getText());
                colaborador.setNoPersonal(tfNoPersonal.getText());
                colaborador.setPassword(tfContra.getText());
                colaborador.setCorreo(tfCorreo.getText());
                colaborador.setCurp(tfCURP.getText());
                colaborador.setIdRol(cbRol.getSelectionModel().getSelectedIndex()+1);
                if(cbRol.getSelectionModel().getSelectedIndex()==1){
                    colaborador.setNumeroLicencia(tfNumLicencia.getText());
                }
                
                editarDatosColaborador(colaborador);
            }
        }
        
    }

    private void cargarDatosEdicion() {
        tfNombre.setText(this.colaboradorEedicion.getNombre());
        tfPaterno.setText(this.colaboradorEedicion.getApellidoPaterno());
        tfMaterno.setText(this.colaboradorEedicion.getApellidoMaterno());
        tfCURP.setText(this.colaboradorEedicion.getCurp());
        tfContra.setText(this.colaboradorEedicion.getPassword());
        tfCorreo.setText(this.colaboradorEedicion.getCorreo());
        tfNoPersonal.setText(this.colaboradorEedicion.getNoPersonal());
        int posicion= buscarIdRol(this.colaboradorEedicion.getIdRol());
        cbRol.getSelectionModel().select(posicion);
        if(this.colaboradorEedicion.getIdRol()==2){
        tfNumLicencia.setText(this.colaboradorEedicion.getNumeroLicencia());
        }
    }
    private void guardarDatosColaborador(Colaborador colaborador){
        Mensaje msj=ColaboradorDAO.registrarColaborador(colaborador);
        if(!msj.isError()){
            Utilidades.mostrarNotificacion("Registro exitoso", "La informacion del colaborador "+colaborador.getNombre()
                    +" "+colaborador.getApellidoPaterno()+ " "+", fue registrada exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Nuevo Registro", colaborador.getNombre());
        }else{
            Utilidades.mostrarNotificacion("Error al guardar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
        
    }
    private void cerrarVentana(){
        Stage base= (Stage)tfNombre.getScene().getWindow();
        base.close();
    }

    private boolean validarCampos() {
    boolean validos = true; // Se inicia como true y solo cambia a false si hay errores

    // Validación del nombre
    if (tfNombre.getText().isEmpty()) {
        validos = false;
        errorNombre.setText("Por favor ingrese un nombre de hasta 50 caracteres");
    } else {
        errorNombre.setText("");
    }

    // Validación del apellido paterno
    if (tfPaterno.getText().isEmpty()) {
        validos = false;
        errorPaterno.setText("Por favor ingrese un apellido de hasta 50 caracteres");
    } else {
        errorPaterno.setText("");
    }

    // Validación del apellido materno
    if (tfMaterno.getText().isEmpty()) {
        validos = false;
        errorMaterno.setText("Por favor ingrese un apellido de hasta 50 caracteres");
    } else {
        errorMaterno.setText("");
    }

    // Validación del CURP
    if (tfCURP.getText().isEmpty() || tfCURP.getText().length() > 18) {
        validos = false;
        errorCurp.setText("Por favor ingrese un CURP de hasta 18 caracteres");
    } else {
        errorCurp.setText("");
    }

    // Validación del correo
    if (tfCorreo.getText().isEmpty() || !tfCorreo.getText().contains("@")) {
        validos = false;
        errorCorreo.setText("Por favor ingrese un correo válido");
    } else {
        errorCorreo.setText("");
    }

    // Validación de la contraseña
    if (tfContra.getText().isEmpty() || tfContra.getText().length() <= 8 || 
        !tfContra.getText().matches("^(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$")) {
        validos = false;
        errorContra.setText("Por favor introduzca una contraseña con \n al menos 8 caracteres, un número y un símbolo");
    } else {
        errorContra.setText("");
    }

    // Validación del número de personal
    if (tfNoPersonal.getText().isEmpty()) {
        validos = false;
        errorNoPersonal.setText("Por favor ingrese un número de personal válido");
    } else {
        errorNoPersonal.setText("");
    }

    // Validación del rol
    if (cbRol.getSelectionModel().isEmpty()) {
        validos = false;
        errorRol.setText("Por favor escoja un rol");
    } else {
        errorRol.setText("");
    }

    // Validación del número de licencia si el rol seleccionado es "conductor" (índice 1)
    if (cbRol.getSelectionModel().getSelectedIndex() == 1 && tfNumLicencia.getText().isEmpty()) {
        validos = false;
        errorNumLicencia.setText("Por favor ingrese un número de licencia de conductor");
    } else {
        errorNumLicencia.setText("");
    }

    return validos;
}


    private void editarDatosColaborador(Colaborador colaborador) {
    Mensaje msj = ColaboradorDAO.actualizarColaborador(colaborador);
    if (!msj.isError()) {
        Utilidades.mostrarNotificacion("Actualización exitosa", "La información del colaborador " +
                colaborador.getNombre() + " " + colaborador.getApellidoPaterno() + " fue actualizada exitosamente", Alert.AlertType.INFORMATION);
        cerrarVentana();
        observador.notificarOperacion("Edición de Registro", colaborador.getNombre());
        
    } else {
        Utilidades.mostrarNotificacion("Error al actualizar", msj.getMensaje(), Alert.AlertType.ERROR);
    }
    
    }
}
