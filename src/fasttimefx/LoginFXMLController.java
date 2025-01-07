/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.LoginDAO;
import fasttimefx.pojo.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private TextField tfCorreo;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label ErrorCorreo;
    @FXML
    private Label ErrorContraseña;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    private void clickIngresar(ActionEvent event) {
        String correo = tfCorreo.getText();
        String password = tfPassword.getText();
        if(validarCampos(correo, password)){
            verificarCredenciales(correo, password);
        }
        
    }
    private void verificarCredenciales(String NoPersonal, String Password){
        Login respuestaLogin = LoginDAO.iniciarSesion(NoPersonal, Password);
        if(!respuestaLogin.getError()){
            
            Utilidades.mostrarNotificacion("Bienvenido", "Bienvenido(a) a timefast", Alert.AlertType.INFORMATION);
            irPantallaPrincipal();
    }else{
            
            Utilidades.mostrarNotificacion("Error", "No se pudo autenticar", Alert.AlertType.ERROR);
        }
        
       
    }
    
    private boolean validarCampos(String NoPersonal, String Password){
        boolean camposValidos=true;
        ErrorContraseña.setText("");
        ErrorCorreo.setText("");
        if(NoPersonal.isEmpty()){
            camposValidos=false;
            ErrorCorreo.setText("Numero de Personal Obligatorio");
            }
        if(Password.isEmpty()){
            camposValidos=false;
            ErrorContraseña.setText("Contraseña Obligatorio");
            }
         
       return camposValidos;
    }
    private void irPantallaPrincipal(){
        try {
            Stage escenarioBase = (Stage)ErrorCorreo.getScene().getWindow();
            
            Parent principal = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
            
            Scene escenaPrincipal = new Scene(principal);
            
            escenarioBase.setScene(escenaPrincipal);
            escenarioBase.setTitle("Pantalla Principal");
            escenarioBase.show();
            
        } catch (IOException ex) {
            Utilidades.mostrarNotificacion("Error", 
                    "De momento no se puede mostrar la pantalla principal", Alert.AlertType.ERROR);
        }
        
                
    }
}
