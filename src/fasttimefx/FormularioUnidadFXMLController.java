/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx;

import Utilidades.Utilidades;
import fasttimefx.dao.RolDAO;
import fasttimefx.dao.TipoDAO;
import fasttimefx.dao.UnidadDAO;
import fasttimefx.pojo.Cliente;
import fasttimefx.pojo.Mensaje;
import fasttimefx.pojo.Rol;
import fasttimefx.pojo.Tipo;
import fasttimefx.pojo.Unidad;
import java.net.URL;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class FormularioUnidadFXMLController implements Initializable {

    private NotificadorOperaciones observador;
    private Unidad unidadEdicion;
    private boolean modoEdicion = false;
    @FXML
    private TextField tfMarca;
    @FXML
    private TextField tfAnio;
    @FXML
    private ComboBox<Tipo> cbTipo;
    @FXML
    private TextField tfVin;
    @FXML
    private Button btnAgregar;
    @FXML
    private Label errorMarca;
    @FXML
    private Label errorModelo;
    @FXML
    private Label errorAnio;
    @FXML
    private Label errorTipo;
    @FXML
    private Label errorVin;
    @FXML
    private TextField tfModelo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      cargarTipoUnidad();
    }    

    @FXML
    private void clicGuardarUnidad(ActionEvent event) {
        if(validarCampos()!=false){
            Unidad unidad=new Unidad();
            if(!modoEdicion){
                String marca=tfMarca.getText();
                String modelo=tfModelo.getText();
                String anio=tfAnio.getText();
                String vin=tfVin.getText();
                Integer idTipo= cbTipo.getSelectionModel().getSelectedItem().getIdTipo();
                
                unidad.setMarca(marca);
                unidad.setModelo(modelo);
                unidad.setAño(anio);
                unidad.setVin(vin);
                unidad.setIdTipo(idTipo);
                
                guardarDatosUnidad(unidad);
            }else{
                unidad.setIdUnidad(this.unidadEdicion.getIdUnidad());
                unidad.setMarca(tfMarca.getText());
                unidad.setModelo(tfModelo.getText());
                unidad.setAño(tfAnio.getText());
                unidad.setVin(tfVin.getText());
                unidad.setIdTipo(cbTipo.getSelectionModel().getSelectedItem().getIdTipo());
                editarDatosUnidad(unidad);
            }
        }
    }
    public void inicializarValores(NotificadorOperaciones observador,Unidad unidadEdicion){
        this.observador=observador;
        this.unidadEdicion=unidadEdicion;
        if(unidadEdicion!=null){
            modoEdicion=true;
            cargarDatosEdicion();
        }
    }  
    
    private void cargarTipoUnidad(){
       ObservableList<Tipo> tiposUnidades = FXCollections.observableArrayList();
       tiposUnidades.add(new Tipo(1, "Administrador"));
       tiposUnidades.add(new Tipo(2, "Conductor"));
       tiposUnidades.add(new Tipo(3, "Operador"));
        cbTipo.setItems(tiposUnidades);
    } 
    public boolean validarCampos(){
        boolean camposValidos=true;
        
        if(tfMarca.getText().isEmpty()){
            camposValidos=false;
            errorMarca.setText("por favor ingrese una marca");
        }else{
            errorMarca.setText("");
        }if(tfModelo.getText().isEmpty()){
            camposValidos=false;
            errorModelo.setText("por favor ingrese un modelo");
        }else{
            errorModelo.setText("");
        }if(tfAnio.getText().isEmpty()||Integer.parseInt(tfAnio.getText())<1950||Integer.parseInt(tfAnio.getText())>2026 ){
            camposValidos=false;
            errorAnio.setText("Por favor ingrese un año valido, si se trata de un vehiculo anterior a 1950 contacte a soporte");
        }else{
            errorAnio.setText("");
        }if(tfVin.getText().isEmpty()){
            camposValidos=false;
            errorVin.setText("Por favor ingrese un VIN");
        }else{
            errorVin.setText("");
        }if(cbTipo.getSelectionModel().isEmpty()){
            camposValidos=false;
            errorTipo.setText("Por favor seleccione un tipo de vehiculo");
        }else{
            errorTipo.setText("");
        }
        return camposValidos;
    }
    
    
    public void cargarDatosEdicion(){
        tfMarca.setText(this.unidadEdicion.getMarca());
        tfModelo.setText(this.unidadEdicion.getModelo());
        tfAnio.setText(this.unidadEdicion.getAño());
        tfVin.setText(this.unidadEdicion.getVin());
        int posicion= buscarIdTipo(this.unidadEdicion.getIdTipo());
        cbTipo.getSelectionModel().select(posicion);
        tfVin.setDisable(true);
    }
    
    private void guardarDatosUnidad(Unidad unidad){
        Mensaje msj=UnidadDAO.registrarUnidad(unidad);
        if(!msj.isError()){
            Utilidades.mostrarNotificacion("Registro exitoso", "La informacion de la unidad "+unidad.getMarca()
                    +" "+unidad.getModelo()+ " "+ unidad.getAño()+", fue registrada exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Nuevo Registro", unidad.getMarca());
        }else{
            Utilidades.mostrarNotificacion("Error al guardar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
        
    }
    
    private void editarDatosUnidad(Unidad unidad){
        Mensaje msj = UnidadDAO.actualizarUnidad(unidad);
        if (!msj.isError()) {
            Utilidades.mostrarNotificacion("Actualización exitosa", "La información de la unidad "+unidad.getMarca()
                    +" "+unidad.getModelo()+ " "+ unidad.getAño()+" fue actualizada exitosamente", Alert.AlertType.INFORMATION);
            cerrarVentana();
            observador.notificarOperacion("Edición de Registro", unidad.getModelo());

        } else {
            Utilidades.mostrarNotificacion("Error al actualizar", msj.getMensaje(), Alert.AlertType.ERROR);
        }
    }
    
    private void cerrarVentana(){
        Stage base=(Stage)tfMarca.getScene().getWindow();
        base.close();
    }
    
    private int buscarIdTipo(int idTipo){
        ObservableList<Tipo> tipoUnidades=cbTipo.getItems();
        for (int i=0; i<tipoUnidades.size();i++){
            if(tipoUnidades.get(i).getIdTipo()==idTipo)
                return 1;
        }
        return 0;
    }
    
}
