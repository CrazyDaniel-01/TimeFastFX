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
    private String DescripcionRol;

    public Rol() {
    }

    public Rol(Integer idRol, String DescripcionRol) {
        this.idRol = idRol;
        this.DescripcionRol = DescripcionRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcionRol() {
        return DescripcionRol;
    }

    public void setDescripcionRol(String DescripcionRol) {
        this.DescripcionRol = DescripcionRol;
    }

    // Sobrescribir toString para mostrar la descripción del rol en el ComboBox
    @Override
    public String toString() {
        return DescripcionRol;
    }
}
