package com.utn.frsf.Model;

import javax.persistence.*;

@Entity
@Table(name = "factores_caracteristicas")
public class FactoresCaracteristicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factor_caracteristica")
    private Integer id_factor_caracteristica;

    @Column(name = "ajuste_por_hijo",nullable = false)
    private Float ajuste_por_hijo;

    @Column(name = "derechos_de_emision",nullable = false)
    private Float derechos_de_emision;

    @Column(name = "descuento_por_unidad_adicional",nullable = false)
    private Float descuento_por_unidad_adicional;

}
