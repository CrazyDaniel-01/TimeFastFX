/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO actualizado para representar un Paquete.
 *
 * @author afs30
 */
public class Paquete {
    private Integer idPaquete;
    private String numeroGuia;
    private String descripcionPaquete;
    private Float peso;
    private String dimensiones;
    private Float alto;
    private Float ancho;
    private Float profundidad;
    private Integer idEnvio;
    private String envio;

    // Lista adicional de paquetes relacionados (si es necesario para lógica interna)
    private List<Paquete> paquetesRelacionados;

    public Paquete() {
        this.paquetesRelacionados = new ArrayList<>();
    }

    public Paquete(Integer idPaquete, String numeroGuia, String descripcionPaquete, Float peso, String dimensiones,
                   Float alto, Float ancho, Float profundidad, Integer idEnvio, String envio) {
        this.idPaquete = idPaquete;
        this.numeroGuia = numeroGuia;
        this.descripcionPaquete = descripcionPaquete;
        this.peso = peso;
        this.dimensiones = dimensiones;
        this.alto = alto;
        this.ancho = ancho;
        this.profundidad = profundidad;
        this.idEnvio = idEnvio;
        this.envio = envio;
        this.paquetesRelacionados = new ArrayList<>();
    }

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getDescripcionPaquete() {
        return descripcionPaquete;
    }

    public void setDescripcionPaquete(String descripcionPaquete) {
        this.descripcionPaquete = descripcionPaquete;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public Float getAlto() {
        return alto;
    }

    public void setAlto(Float alto) {
        this.alto = alto;
    }

    public Float getAncho() {
        return ancho;
    }

    public void setAncho(Float ancho) {
        this.ancho = ancho;
    }

    public Float getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Float profundidad) {
        this.profundidad = profundidad;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    public List<Paquete> getPaquetesRelacionados() {
        return paquetesRelacionados;
    }

    public void setPaquetesRelacionados(List<Paquete> paquetesRelacionados) {
        this.paquetesRelacionados = paquetesRelacionados;
    }
}
