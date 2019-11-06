package com.utn.frsf.DTO;

import com.utn.frsf.Enums.TipoDocumento;

public class ClienteDTO {
    private Long numeroDocumento;
    private String apellido;
    private String nombre;
    private TipoDocumento tipoDocumento;
    private Integer nroCliente;

    public ClienteDTO(Long numeroDocumento, String apellido, String nombre, TipoDocumento tipoDocumento, Integer nroCliente) {
        this.numeroDocumento = numeroDocumento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.nroCliente = nroCliente;
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
}
