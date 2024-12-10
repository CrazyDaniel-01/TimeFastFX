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
    private String Nombre;
    private Integer IdColaborador;
    private Integer IdRol;
    private String ApellidoMaterno;
    private String ApellidoPaterno;
    private String FechaNacimiento;
    private String NoPersonal;
    private String Telefono;
    private Integer Peso;
    private Integer Estatura;
    private String Correo;
    private String Rfc;
    private String Curp;
    private String Password;
    

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
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getIdColaborador() {
        return IdColaborador;
    }

    public void setIdColaborador(Integer IdColaborador) {
        this.IdColaborador = IdColaborador;
    }

    public Integer getIdRol() {
        return IdRol;
    }

    public void setIdRol(Integer IdRol) {
        this.IdRol = IdRol;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getNumPersonal() {
        return NoPersonal;
    }

    public void setNumPersonal(String NoPersonal) {
        this.NoPersonal = NoPersonal;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public Integer getPeso() {
        return Peso;
    }

    public void setPeso(Integer Peso) {
        this.Peso = Peso;
    }

    public Integer getEstatura() {
        return Estatura;
    }

    public void setEstatura(Integer Estatura) {
        this.Estatura = Estatura;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getRfc() {
        return Rfc;
    }

    public void setRfc(String Rfc) {
        this.Rfc = Rfc;
    }

    public String getCurp() {
        return Curp;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Colaborador(String Nombre, Integer IdColaborador, Integer IdRol, String ApellidoMaterno, String ApellidoPaterno, String FechaNacimiento, String NoPersonal, String Telefono, Integer Peso, Integer Estatura, String Correo, String Rfc, String Curp, String Password) {
        this.Nombre = Nombre;
        this.IdColaborador = IdColaborador;
        this.IdRol = IdRol;
        this.ApellidoMaterno = ApellidoMaterno;
        this.ApellidoPaterno = ApellidoPaterno;
        this.FechaNacimiento = FechaNacimiento;
        this.NoPersonal = NoPersonal;
        this.Telefono = Telefono;
        this.Peso = Peso;
        this.Estatura = Estatura;
        this.Correo = Correo;
        this.Rfc = Rfc;
        this.Curp = Curp;
        this.Password = Password;
    }

    public  Colaborador() {
        this.colaboradores = new ArrayList<>();
    }

}
