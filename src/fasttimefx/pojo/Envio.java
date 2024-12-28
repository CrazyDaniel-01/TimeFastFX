package fasttimefx.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO actualizado para representar un Envio.
 *
 * @author afs30
 */
public class Envio {

    public Envio(Integer idEnvio, Integer idCliente, Integer idOrigen, Integer idDestino, Integer idPaquete, String calle, Integer numero, String colonia, Integer codigoPostal, String ciudad, String estado, String destino, String origen, String noGuia, String costo, String status, String cliente, String conductor, List<Envio> enviosRelacionados) {
        this.idEnvio = idEnvio;
        this.idCliente = idCliente;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.idPaquete = idPaquete;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.destino = destino;
        this.origen = origen;
        this.noGuia = noGuia;
        this.costo = costo;
        this.status = status;
        this.cliente = cliente;
        this.conductor = conductor;
        this.enviosRelacionados = enviosRelacionados;
    }
    private Integer idEnvio;
    private Integer idCliente;
    private Integer idOrigen;
    private Integer idDestino;
    private Integer idPaquete;
    private String calle;
    private Integer numero;
    private String colonia;
    private Integer codigoPostal;
    private String ciudad;
    private String estado;
    private String destino;
    private String origen;
    private String noGuia;
    private String costo;
    private String status;
    private String cliente;
    private String conductor;

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }
    

    // Lista adicional para posibles relaciones con otros envíos
    private List<Envio> enviosRelacionados;

    public Envio() {
        this.enviosRelacionados = new ArrayList<>();
    }

    

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(Integer idOrigen) {
        this.idOrigen = idOrigen;
    }

    public Integer getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Integer idDestino) {
        this.idDestino = idDestino;
    }

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getNoGuia() {
        return noGuia;
    }

    public void setNoGuia(String noGuia) {
        this.noGuia = noGuia;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Envio> getEnviosRelacionados() {
        return enviosRelacionados;
    }

    public void setEnviosRelacionados(List<Envio> enviosRelacionados) {
        this.enviosRelacionados = enviosRelacionados;
    }
}
