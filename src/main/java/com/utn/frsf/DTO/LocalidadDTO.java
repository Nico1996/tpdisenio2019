package com.utn.frsf.DTO;

public class LocalidadDTO {
    private Integer id_localidad;
    private String localidad;
    private Float factor;

    public LocalidadDTO(Integer id_localidad, String localidad, Float factor) {
        this.id_localidad = id_localidad;
        this.localidad = localidad;
        this.factor = factor;
    }

    public Integer getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(Integer id_localidad) {
        this.id_localidad = id_localidad;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Float getFactor() {
        return factor;
    }

    public void setFactor(Float factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return localidad;
    }
}
