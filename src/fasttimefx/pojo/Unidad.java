package fasttimefx.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una unidad con sus atributos principales.
 */
public class Unidad {

    
    private Integer idUnidad;
    private String marca;
    private String modelo;
    private String año;
    private String vin;
    private Integer idTipo;
    private String idInterno;
    private String descripcionTipo;
    private List<Unidad> unidades;
    private String tipo;

    // Constructor vacío que inicializa la lista de unidades
    public Unidad() {
        this.unidades = new ArrayList<>();
    }

    // Constructor con parámetros

    public Unidad(Integer idUnidad, String marca, String modelo, String año, String vin, Integer idTipo, String idInterno, String descripcionTipo, List<Unidad> unidades, String tipo) {
        this.idUnidad = idUnidad;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.vin = vin;
        this.idTipo = idTipo;
        this.idInterno = idInterno;
        this.descripcionTipo = descripcionTipo;
        this.unidades = unidades;
        this.tipo = tipo;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(String idInterno) {
        this.idInterno = idInterno;
    }

    public String getDescripcionTipo() {
        return descripcionTipo;
    }

    public void setDescripcionTipo(String descripcionTipo) {
        this.descripcionTipo = descripcionTipo;
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   @Override
    public String toString() {
    return this.marca;
}
}