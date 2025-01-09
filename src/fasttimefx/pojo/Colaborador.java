/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO actualizado para representar un Colaborador.
 *
 * @author Daniel
 */
public class Colaborador {
    private Integer idColaborador;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String curp;
    private String correo;
    private String password;
    private Integer idRol;
    private String rol;
    private String fotoBase64;
    private String noLicencia;
    private String noPersonal;
    private Integer idConductor;
<<<<<<< Updated upstream
    private String numeroLicencia;
=======
    private String telefono;
    private String fotografia;

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public Colaborador(String fotografia) {
        this.fotografia = fotografia;
    }
>>>>>>> Stashed changes

    // Lista adicional de colaboradores (si es necesario para relaciones o lógica interna)
    private List<Colaborador> colaboradores;

    public Colaborador() {
        this.colaboradores = new ArrayList<>();
    }

    public Colaborador(Integer idColaborador, String nombre, String apellidoPaterno, String apellidoMaterno,
                        String curp, String correo, String password, Integer idRol, String rol, String fotoBase64,
                        String noLicencia, String noPersonal, Integer idConductor, String numeroLicencia) {
        this.idColaborador = idColaborador;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.curp = curp;
        this.correo = correo;
        this.password = password;
        this.idRol = idRol;
        this.rol = rol;
        this.fotoBase64 = fotoBase64;
        this.noLicencia = noLicencia;
        this.noPersonal = noPersonal;
        this.idConductor = idConductor;
        this.numeroLicencia = numeroLicencia;
        this.colaboradores = new ArrayList<>();
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFotoBase64() {
        return fotoBase64;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }

    public String getNoLicencia() {
        return noLicencia;
    }

    public void setNoLicencia(String noLicencia) {
        this.noLicencia = noLicencia;
    }

    public String getNoPersonal() {
        return noPersonal;
    }

    public void setNoPersonal(String noPersonal) {
        this.noPersonal = noPersonal;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
    
    @Override
    public String toString() {
    return this.nombre; // Reemplaza "nombre" con el atributo que desees mostrar
}
public Colaborador(Integer idConductor) {
    this.idConductor = idConductor;
}

}
