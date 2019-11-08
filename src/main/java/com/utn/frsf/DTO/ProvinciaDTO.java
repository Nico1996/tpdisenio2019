package com.utn.frsf.DTO;

public class ProvinciaDTO {
    private Integer id_provincia;
    private String provincia;

    public Integer getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Integer id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public ProvinciaDTO(Integer id_provincia, String provincia) {
        this.id_provincia = id_provincia;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return provincia;
    }
}
