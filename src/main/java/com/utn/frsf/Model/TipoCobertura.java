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
    private TipoCoberturaEnum tipoCoberturaEnum;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "fact_caract_tipo_cob",nullable = false)
    private Float fact_caract_tipo_cob;

}
