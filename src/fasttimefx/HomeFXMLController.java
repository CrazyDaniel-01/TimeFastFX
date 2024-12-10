/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx;

import fasttimefx.pojo.Cliente;
import fasttimefx.pojo.Colaborador;
import fasttimefx.pojo.Envio;
import fasttimefx.pojo.Paquete;
import fasttimefx.pojo.Unidad;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colApellidoP;
    @FXML
    private TableColumn<?, ?> colApellidoM;
    @FXML
    private TableColumn<?, ?> colCURP;
    @FXML
    private TableColumn<?, ?> colCorreo;
    @FXML
    private TableColumn<?, ?> colRol;
 


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

    @Override
    public void notificarOperacion(String tipo, String nombre) {
        System.out.println("Tipo operacion: "+tipo);
        System.out.println("Nombre Colaborador: "+nombre);
        
    }
    
}
