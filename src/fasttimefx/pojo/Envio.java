/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasttimefx.pojo;

/**
 *
 * @author afs30
 */
public class Envio {
    private Integer IdEnvio;
    private Integer IdCliente;
    private Integer IdOrigen;
    private Integer IdDestino;
    private Integer IdPaquete;
    private String Calle;
    private Integer Numero;
    private String Colonia;
    private Integer CodigoPostal;
    private String Ciudad;
    private String Estado;
    private String Destino;
    private String Origen;
    private String NoGuia;
    private String Costo;
    private String Status;
    private String Cliente;

    public Envio() {
    }

    public Envio(Integer IdEnvio, Integer IdCliente, Integer IdOrigen, Integer IdDestino, Integer IdPaquete, String Calle, Integer Numero, String Colonia, Integer CodigoPostal, String Ciudad, String Estado, String Destino, String Origen, String NoGuia, String Costo, String Status, String Cliente) {
        this.IdEnvio = IdEnvio;
        this.IdCliente = IdCliente;
        this.IdOrigen = IdOrigen;
        this.IdDestino = IdDestino;
        this.IdPaquete = IdPaquete;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Colonia = Colonia;
        this.CodigoPostal = CodigoPostal;
        this.Ciudad = Ciudad;
        this.Estado = Estado;
        this.Destino = Destino;
        this.Origen = Origen;
        this.NoGuia = NoGuia;
        this.Costo = Costo;
        this.Status = Status;
        this.Cliente = Cliente;
    }

    public Integer getIdEnvio() {
        return IdEnvio;
    }

    public void setIdEnvio(Integer IdEnvio) {
        this.IdEnvio = IdEnvio;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Integer getIdOrigen() {
        return IdOrigen;
    }

    public void setIdOrigen(Integer IdOrigen) {
        this.IdOrigen = IdOrigen;
    }

    public Integer getIdDestino() {
        return IdDestino;
    }

    public void setIdDestino(Integer IdDestino) {
        this.IdDestino = IdDestino;
    }

    public Integer getIdPaquete() {
        return IdPaquete;
    }

    public void setIdPaquete(Integer IdPaquete) {
        this.IdPaquete = IdPaquete;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer Numero) {
        this.Numero = Numero;
    }

    public String getColonia() {
        return Colonia;
    }

    public void setColonia(String Colonia) {
        this.Colonia = Colonia;
    }

    public Integer getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(Integer CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }

    public String getNoGuia() {
        return NoGuia;
    }

    public void setNoGuia(String NoGuia) {
        this.NoGuia = NoGuia;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String Costo) {
        this.Costo = Costo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }
    

}
