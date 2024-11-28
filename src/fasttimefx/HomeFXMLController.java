/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class HomeFXMLController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
