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
    private String DescripcionTipo;

    public Tipo() {
    }

    public Tipo(Integer idTipo, String DescripcionTipo) {
        this.idTipo = idTipo;
        this.DescripcionTipo = DescripcionTipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcionTipo() {
        return DescripcionTipo;
    }

    public void setDescripcionTipo(String DescripcionTipo) {
        this.DescripcionTipo = DescripcionTipo;
    }
}
