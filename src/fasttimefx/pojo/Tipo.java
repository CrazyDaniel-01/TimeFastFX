/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.pojo;

/**
 *
 * @author Daniel
 */
public class Tipo {
    private Integer idTipo;
    private String descripcionTipo;

    public Tipo() {
    }

    public Tipo(Integer idTipo, String descripcionTipo) {
        this.idTipo = idTipo;
        this.descripcionTipo = descripcionTipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String DescripcionTipo) {
        this.descripcionTipo = DescripcionTipo;
    }
    
    @Override
public String toString() {
    return descripcionTipo; // Muestra la descripción del tipo en el ComboBox
}

}

