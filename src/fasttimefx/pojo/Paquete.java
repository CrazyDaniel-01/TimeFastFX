/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.pojo;

import java.util.logging.Logger;

/**
 *
 * @author afs30
 */
public class Paquete {
    private Integer IdPaquete;
    private String NumeroGuia;
    private String DescripcionPaquete;
    private Float Peso;
    private String Dimensiones;
    private Float Alto;
    private Float Ancho;
    private Float Profundidad;
    private Integer IdEnvio;
    private String Envio;
   

    public Paquete() {
    }

    public Paquete(Integer IdPaquete, String NumeroGuia, String DescripcionPaquete, Float Peso, String Dimensiones, Float Alto, Float Ancho, Float Profundidad, Integer IdEnvio, String Envio) {
        this.IdPaquete = IdPaquete;
        this.NumeroGuia = NumeroGuia;
        this.DescripcionPaquete = DescripcionPaquete;
        this.Peso = Peso;
        this.Dimensiones = Dimensiones;
        this.Alto = Alto;
        this.Ancho = Ancho;
        this.Profundidad = Profundidad;
        this.IdEnvio = IdEnvio;
        this.Envio = Envio;
    }

    public Integer getIdPaquete() {
        return IdPaquete;
    }

    public void setIdPaquete(Integer IdPaquete) {
        this.IdPaquete = IdPaquete;
    }

    public String getNumeroGuia() {
        return NumeroGuia;
    }

    public void setNumeroGuia(String NumeroGuia) {
        this.NumeroGuia = NumeroGuia;
    }

    public String getDescripcionPaquete() {
        return DescripcionPaquete;
    }

    public void setDescripcionPaquete(String DescripcionPaquete) {
        this.DescripcionPaquete = DescripcionPaquete;
    }

    public Float getPeso() {
        return Peso;
    }

    public void setPeso(Float Peso) {
        this.Peso = Peso;
    }

    public String getDimensiones() {
        return Dimensiones;
    }

    public void setDimensiones(String Dimensiones) {
        this.Dimensiones = Dimensiones;
    }

    public Float getAlto() {
        return Alto;
    }

    public void setAlto(Float Alto) {
        this.Alto = Alto;
    }

    public Float getAncho() {
        return Ancho;
    }

    public void setAncho(Float Ancho) {
        this.Ancho = Ancho;
    }

    public Float getProfundidad() {
        return Profundidad;
    }

    public void setProfundidad(Float Profundidad) {
        this.Profundidad = Profundidad;
    }

    public Integer getIdEnvio() {
        return IdEnvio;
    }

    public void setIdEnvio(Integer IdEnvio) {
        this.IdEnvio = IdEnvio;
    }

    public String getEnvio() {
        return Envio;
    }

    public void setEnvio(String Envio) {
        this.Envio = Envio;
    }

    

    
    
}
