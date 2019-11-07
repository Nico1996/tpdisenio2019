package com.utn.frsf.DTO;

public class TipoCoberturaDTO {
    private Integer id_cobertura;
    private String nombre_cobertura;
    private String descripcion;
    private Float valor_fact_caract;

    public TipoCoberturaDTO(Integer id_cobertura, String nombre_cobertura, String descripcion, Float valor_fact_caract) {
        this.id_cobertura = id_cobertura;
        this.nombre_cobertura = nombre_cobertura;
        this.descripcion = descripcion;
        this.valor_fact_caract = valor_fact_caract;
    }

    public Integer getId_cobertura() {
        return id_cobertura;
    }

    public void setId_cobertura(Integer id_cobertura) {
        this.id_cobertura = id_cobertura;
    }

    public String getNombre_cobertura() {
        return nombre_cobertura;
    }

    public void setNombre_cobertura(String nombre_cobertura) {
        this.nombre_cobertura = nombre_cobertura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getValor_fact_caract() {
        return valor_fact_caract;
    }

    public void setValor_fact_caract(Float valor_fact_caract) {
        this.valor_fact_caract = valor_fact_caract;
    }

    @Override
    public String toString() {
        return nombre_cobertura;
    }
}
