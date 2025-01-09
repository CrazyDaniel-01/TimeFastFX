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
    private String anio;
    private String vin;
    private Integer idTipo;
    private String idInterno;
    private String tipoUnidad;
    private List<Unidad> unidades;

    // Constructor vacío que inicializa la lista de unidades
    public Unidad() {
        this.unidades = new ArrayList<>();
    }

    // Constructor con parámetros
    public Unidad(Integer idUnidad, String marca, String modelo, String anio, String vin, Integer idTipo, String idInterno, String tipoUnidad) {
        this.idUnidad = idUnidad;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.vin = vin;
        this.idTipo = idTipo;
        this.idInterno = idInterno;
        this.tipoUnidad = tipoUnidad;
        this.unidades = new ArrayList<>();
    }

    // Getters y setters

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

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
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

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
    }
<<<<<<< Updated upstream
}
=======

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
<<<<<<< Updated upstream
}
>>>>>>> Stashed changes
=======
 
    public Unidad(Integer idUnidad) {
    this.idUnidad = idUnidad;
}

    
    
}
>>>>>>> Stashed changes
