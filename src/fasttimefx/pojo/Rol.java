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
public class Rol {
    private Integer idRol;
    private String descripcionRol;

    public Rol() {
    }

    public Rol(Integer idRol, String descripcionRol) {
        this.idRol = idRol;
        this.descripcionRol = descripcionRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    // Sobrescribir toString para mostrar la descripción del rol en el ComboBox
    @Override
    public String toString() {
        return descripcionRol;
    }
}
