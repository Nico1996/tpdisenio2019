package com.utn.frsf.Model;

import com.utn.frsf.Enums.TipoCoberturaEnum;

import javax.persistence.*;

@Entity
@Table(name = "tipo_cobertura")
public class TipoCobertura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cobertura")
    private Integer id_cobertura;

    @Column(name= "nombre_cobertura",nullable = false)
    private String tipoCobertura;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "fact_caract_tipo_cob",nullable = false)
    private Float fact_caract_tipo_cob;

    public Integer getId_cobertura() {
        return id_cobertura;
    }

    public void setId_cobertura(Integer id_cobertura) {
        this.id_cobertura = id_cobertura;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getFact_caract_tipo_cob() {
        return fact_caract_tipo_cob;
    }

    public void setFact_caract_tipo_cob(Float fact_caract_tipo_cob) {
        this.fact_caract_tipo_cob = fact_caract_tipo_cob;
    }

    @Override
    public String toString() {
        return  tipoCobertura ;
    }
}
