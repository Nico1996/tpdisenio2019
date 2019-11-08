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

    @Override
    public String toString() {
        return nombre_modelo;
    }

    public Integer getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Integer id_modelo) {
        this.id_modelo = id_modelo;
    }

    public Float getRobo_por_modelo() {
        return robo_por_modelo;
    }

    public void setRobo_por_modelo(Float robo_por_modelo) {
        this.robo_por_modelo = robo_por_modelo;
    }

    public String getNombre_modelo() {
        return nombre_modelo;
    }

    public void setNombre_modelo(String nombre_modelo) {
        this.nombre_modelo = nombre_modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
