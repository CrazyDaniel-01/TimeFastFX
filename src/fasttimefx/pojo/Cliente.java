/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.pojo;

/**
 *
 * @author afs30
 */
public class Cliente {
    private Integer IdCliente;
    private String  Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Calle;
    private Integer Numero;
    private String Colonia;
    private Integer CodigoPostal;
    private String Telefono;
    private String Correo;
    private String Direccion; 
    private Integer IdDireccion;

    public Cliente() {
    }

    public Cliente(Integer IdCliente, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String Calle, Integer Numero, String Colonia, Integer CodigoPostal, String Telefono, String Correo, String Direccion, Integer IdDireccion) {
        this.IdCliente = IdCliente;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Colonia = Colonia;
        this.CodigoPostal = CodigoPostal;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Direccion = Direccion;
        this.IdDireccion = IdDireccion;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer Numero) {
        this.Numero = Numero;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public Integer getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(Integer CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Integer getIdDireccion() {
        return IdDireccion;
    }

    public void setIdDireccion(Integer IdDireccion) {
        this.IdDireccion = IdDireccion;
    }

   
}
