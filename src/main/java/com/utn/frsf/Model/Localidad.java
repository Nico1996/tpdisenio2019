package com.utn.frsf.Model;

import javax.persistence.*;

@Entity
@Table(name="localidad")
public class Localidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localidad")
    private Integer id_localidad;

    @Column(name = "nombre_localidad",nullable = false)
    private String nombre_localidad;

    @Column(name = "codigo_postal",nullable = false)
    private Integer codigo_postal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_provincia")
    private Provincia provincia;

    @Column(name = "factor_localidad")
    private Float factor_localidad;
}
