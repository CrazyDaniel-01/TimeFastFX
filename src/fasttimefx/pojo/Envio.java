package fasttimefx.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO actualizado para representar un Envio.
 *
 * @author afs30
 */
public class Envio {

  
    private Integer idEnvio;
    private Integer idCliente;
    private Integer idOrigen;
    private Integer idDestino;
    private Integer idPaquete;
    private String calleOrigen;
    private Integer numeroOrigen;
    private String coloniaOrigen;
    private Integer codigoPostalOrigen;
    private String ciudadOrigen;
    private String estadoOrigen;
    private String calleDestino;
    private Integer numeroDestino;
    private String coloniaDestino;
    private Integer codigoPostalDestino;
    private String ciudadDestino;
    private String estadoDestino;
    private String destino;
    private String origen;
    private String noGuia;
    private String costo;
    private String status;
    private String cliente;
    private String conductor;
    private String numeroGuia;
    private String motivo;

    public Envio(Integer idEnvio, Integer idCliente, Integer idOrigen, Integer idDestino, Integer idPaquete, String calleOrigen, Integer numeroOrigen, String coloniaOrigen, Integer codigoPostalOrigen, String ciudadOrigen, String estadoOrigen, String calleDestino, Integer numeroDestino, String coloniaDestino, Integer codigoPostalDestino, String ciudadDestino, String estadoDestino, String destino, String origen, String noGuia, String costo, String status, String cliente, String conductor, String numeroGuia, String motivo, List<Envio> enviosRelacionados) {
        this.idEnvio = idEnvio;
        this.idCliente = idCliente;
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.idPaquete = idPaquete;
        this.calleOrigen = calleOrigen;
        this.numeroOrigen = numeroOrigen;
        this.coloniaOrigen = coloniaOrigen;
        this.codigoPostalOrigen = codigoPostalOrigen;
        this.ciudadOrigen = ciudadOrigen;
        this.estadoOrigen = estadoOrigen;
        this.calleDestino = calleDestino;
        this.numeroDestino = numeroDestino;
        this.coloniaDestino = coloniaDestino;
        this.codigoPostalDestino = codigoPostalDestino;
        this.ciudadDestino = ciudadDestino;
        this.estadoDestino = estadoDestino;
        this.destino = destino;
        this.origen = origen;
        this.noGuia = noGuia;
        this.costo = costo;
        this.status = status;
        this.cliente = cliente;
        this.conductor = conductor;
        this.numeroGuia = numeroGuia;
        this.motivo = motivo;
        this.enviosRelacionados = enviosRelacionados;
    }

        
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public String getCalleOrigen() {
        return calleOrigen;
    }

    public void setCalleOrigen(String calleOrigen) {
        this.calleOrigen = calleOrigen;
    }

    public Integer getNumeroOrigen() {
        return numeroOrigen;
    }

    public void setNumeroOrigen(Integer numeroOrigen) {
        this.numeroOrigen = numeroOrigen;
    }

    public String getColoniaOrigen() {
        return coloniaOrigen;
    }

    public void setColoniaOrigen(String coloniaOrigen) {
        this.coloniaOrigen = coloniaOrigen;
    }

    public Integer getCodigoPostalOrigen() {
        return codigoPostalOrigen;
    }

    public void setCodigoPostalOrigen(Integer codigoPostalOrigen) {
        this.codigoPostalOrigen = codigoPostalOrigen;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getEstadoOrigen() {
        return estadoOrigen;
    }

    public void setEstadoOrigen(String estadoOrigen) {
        this.estadoOrigen = estadoOrigen;
    }

    public String getCalleDestino() {
        return calleDestino;
    }

    public void setCalleDestino(String calleDestino) {
        this.calleDestino = calleDestino;
    }

    public Integer getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(Integer numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public String getColoniaDestino() {
        return coloniaDestino;
    }

    public void setColoniaDestino(String coloniaDestino) {
        this.coloniaDestino = coloniaDestino;
    }

    public Integer getCodigoPostalDestino() {
        return codigoPostalDestino;
    }

    public void setCodigoPostalDestino(Integer codigoPostalDestino) {
        this.codigoPostalDestino = codigoPostalDestino;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(String estadoDestino) {
        this.estadoDestino = estadoDestino;
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

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    @Override
    public String toString() {
    return this.numeroGuia;
    }
    

    // Lista adicional para posibles relaciones con otros envíos
    private List<Envio> enviosRelacionados;

    public Envio() {
        this.enviosRelacionados = new ArrayList<>();
    }

    

    public List<Envio> getEnviosRelacionados() {
        return enviosRelacionados;
    }

    public void setEnviosRelacionados(List<Envio> enviosRelacionados) {
        this.enviosRelacionados = enviosRelacionados;
    }

    

   
}
