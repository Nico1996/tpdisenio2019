package com.utn.frsf.DTO;

public class MarcaDTO {
    private Integer id_marca;
    private String marca;

    public MarcaDTO(Integer id_marca, String marca) {
        this.id_marca = id_marca;
        this.marca = marca;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String toString() {
        return marca;
    }
}
