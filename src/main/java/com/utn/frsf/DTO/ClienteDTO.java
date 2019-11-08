package com.utn.frsf.DTO;

import com.utn.frsf.Enums.TipoDocumento;

public class ClienteDTO {
    private Long numeroDocumento;
    private String apellido;
    private String nombre;
    private TipoDocumento tipoDocumento;
    private Integer nroCliente;
    private Integer id_cliente;
    private String calle;
    private String numero;
    private Integer cantidad_siniestros;





    public ClienteDTO(Long nro_documento, String apellido, String nombre, TipoDocumento tipoDocumento, Integer nro_cliente, Integer id_cliente) {
        this.numeroDocumento = nro_documento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroCliente = nro_cliente;
        this.id_cliente= id_cliente;
    }

    public ClienteDTO() {
    }

    public Integer getCantidad_siniestros() {
        return cantidad_siniestros;
    }

    public void setCantidad_siniestros(Integer cantidad_siniestros) {
        this.cantidad_siniestros = cantidad_siniestros;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getNroCliente() {
        return nroCliente;
    }

    public void setNroCliente(Integer nroCliente) {
        this.nroCliente = nroCliente;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "numeroDocumento=" + numeroDocumento +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", nroCliente=" + nroCliente +
                ", id_cliente=" + id_cliente +
                '}';
    }
}
