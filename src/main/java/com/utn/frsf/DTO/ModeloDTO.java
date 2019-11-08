package com.utn.frsf.DTO;

public class ModeloDTO {
    private Integer id_modelo;
    private Integer id_marca;
    private String modelo;

    public Integer getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Integer id_modelo) {
        this.id_modelo = id_modelo;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public ModeloDTO(Integer id_modelo, Integer id_marca, String modelo) {
        this.id_modelo = id_modelo;
        this.id_marca = id_marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return modelo;
    }
}
