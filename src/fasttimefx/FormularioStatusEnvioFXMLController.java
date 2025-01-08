/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.EnvioDAO;
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Mensaje;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import observador.NotificadorOperaciones;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class FormularioStatusEnvioFXMLController implements Initializable {

    @FXML
    private Label errorEstado;
    @FXML
    private TextArea taEstado;
    @FXML
    private Button btnEstado;
    private Envio envioEdicion;
    
    private NotificadorOperaciones observador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void recibirEnvio(NotificadorOperaciones observador,Envio envioEdicion){
        this.observador=observador;
        this.envioEdicion=envioEdicion;
    }
    
    @FXML
    private void clicActualizar(ActionEvent event) {
        Envio envio =this.envioEdicion;
        if(taEstado.getText().isEmpty()){
            errorEstado.setText("Por favor ingrese un estado");
        }else{
            envio.setIdEnvio(this.envioEdicion.getIdEnvio());
            envio.setStatus(taEstado.getText());
            envio.setMotivo(taEstado.getText());
            errorEstado.setText("");
            actualizarEstado(envio);
        }
    }
    private void actualizarEstado(Envio envio){
        Mensaje msj=EnvioDAO.actualizarEstadoEnvio(envio);
        if(!msj.isError()){
            Utilidades.mostrarNotificacion("Registro exitoso", "La unidad "+this.envioEdicion.getNumeroGuia() +" fue actualizado exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Cambio Estado", this.envioEdicion.getNumeroGuia() );
        }else{
            Utilidades.mostrarNotificacion("Error al guardar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }
    
    private void cerrarVentana(){
        Stage base= (Stage)errorEstado.getScene().getWindow();
        base.close();
    }
}
