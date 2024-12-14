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
public class BajaUnidad {
    private Integer idUnidad;
    private String motivoBaja;

    public BajaUnidad() {}

    public BajaUnidad(Integer idUnidad, String motivoBaja) {
        this.idUnidad = idUnidad;
        this.motivoBaja = motivoBaja;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }
}
