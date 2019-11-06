package com.utn.frsf.DTO;

import java.util.List;

public class VehiculoDTO {
    private Integer id_vehiculo;
    private Integer chasis;
    private String patente;
    private Integer id_modelo;
    private MedidaDeSeguridadDTO medidasDeSeguridadDTO;
    private Integer kms_año;
    private Integer siniestros;

    public Integer getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Integer id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public Integer getChasis() {
        return chasis;
    }

    public void setChasis(Integer chasis) {
        this.chasis = chasis;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Integer id_modelo) {
        this.id_modelo = id_modelo;
    }
}
