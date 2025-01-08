/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.BajaUnidadDAO;
import fasttimefx.pojo.BajaUnidad;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.Unidad;
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
public class FormularioBajaUnidadFXMLController implements Initializable {

    @FXML
    private Label errorMotivo;
    @FXML
    private TextArea taMotivoBaja;
    private Unidad unidadBaja;
    private NotificadorOperaciones observador;
    @FXML
    private Button btnBaja;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void recibirUnidad(NotificadorOperaciones observador,Unidad unidadBaja){
        this.observador=observador;
        this.unidadBaja=unidadBaja;
    }

    @FXML
    private void clicBajaUnidad(ActionEvent event) {
        BajaUnidad bajaUnidad=new BajaUnidad();
        if(taMotivoBaja.getText().isEmpty()){
            errorMotivo.setText("Por favor ingrese un motivo");
        }else{
            bajaUnidad.setIdUnidad(this.unidadBaja.getIdUnidad());
            bajaUnidad.setMotivoBaja(taMotivoBaja.getText());
            errorMotivo.setText("");
            bajaUnidad(bajaUnidad);
        }
       
    }
    private void bajaUnidad(BajaUnidad bajaUnidad){
        Mensaje msj=BajaUnidadDAO.bajaUnidad(bajaUnidad);
        if(!msj.isError()){
            Utilidades.mostrarNotificacion("Registro exitoso", "La unidad "+this.unidadBaja.getMarca()+" "+this.unidadBaja.getModelo()+" "+"fue registrada exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Baja unidad", this.unidadBaja.getMarca()+" "+this.unidadBaja.getModelo());
        }else{
            Utilidades.mostrarNotificacion("Error al guardar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }
    private void cerrarVentana(){
        Stage base= (Stage)taMotivoBaja.getScene().getWindow();
        base.close();
    }
}
