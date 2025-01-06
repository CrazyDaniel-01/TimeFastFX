/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.pojo;

public class AsociacionVehicular {
  
    private Integer idConductor;
    private Integer idUnidad;

    public AsociacionVehicular() {
    }

    public AsociacionVehicular(Integer idConductor, Integer idUnidad) {
        this.idConductor = idConductor;
        this.idUnidad = idUnidad;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    
}


