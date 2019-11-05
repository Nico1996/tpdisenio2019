package com.utn.frsf.Model;

import javax.persistence.*;

@Entity
@Table(name="modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private  Integer id_modelo;

    @Column(name = "robo_por_modelo",nullable = false)
    private  Float robo_por_modelo;

    @Column(name = "nombre_modelo",nullable = false)
    private   String nombre_modelo;

    @JoinColumn(name="id_marca")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private   Marca marca;
}
