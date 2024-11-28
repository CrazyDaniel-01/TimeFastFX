/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class Colaborador {
    private String nombre;
    private Integer idColaborador;
    private Integer idRol;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String fechaNacimiento;
    private String noPersonal;
    private String telefono;
    private Integer peso;
    private Integer estatura;
    private String correo;
    private String rfc;
    private String curp;
    private String password;
    

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    private String rol;
    private List<Colaborador> colaboradores;

 
    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumPersonal() {
        return noPersonal;
    }

    public void setNumPersonal(String numPersonal) {
        this.noPersonal = numPersonal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getEstatura() {
        return estatura;
    }

    public void setEstatura(Integer estatura) {
        this.estatura = estatura;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Colaborador(String nombre, Integer idColaborador, Integer idRol, String apellidoMaterno, String apellidoPaterno, String fechaNacimiento, String noPersonal, String telefono, Integer peso, Integer estatura, String correo, String rfc, String curp, String password) {
        this.nombre = nombre;
        this.idColaborador = idColaborador;
        this.idRol = idRol;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.noPersonal = noPersonal;
        this.telefono = telefono;
        this.peso = peso;
        this.estatura = estatura;
        this.correo = correo;
        this.rfc = rfc;
        this.curp = curp;
        this.password = password;
    }

    public  Colaborador() {
        this.colaboradores = new ArrayList<>();
    }

}
