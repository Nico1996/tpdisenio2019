package com.utn.frsf.Model;

import javax.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer id_marca;

    @Column(name = "nombre_marca",nullable = false)
    private  String nombre_marca;

}
