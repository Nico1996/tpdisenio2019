package com.utn.frsf.Model;


import javax.persistence.*;

@Entity
@Table(name="provincia")
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_provincia")
    private Integer id_provincia;

    @Column(name = "nombre")
    private String nombre;
}
