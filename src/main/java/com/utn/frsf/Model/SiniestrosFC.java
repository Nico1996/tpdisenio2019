package com.utn.frsf.Model;

import javax.persistence.*;

@Entity
@Table(name = "siniestros_fc")
public class SiniestrosFC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siniestro")
    private Integer id_siniestro;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "factor_caracteristica_siniestro",nullable = false)
    private Float factor_caracteristica_siniestro;

}
