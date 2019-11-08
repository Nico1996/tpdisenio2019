package com.utn.frsf.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vehiculo")
public class Vehiculo {
    @Column(name="id_vehiculo")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Integer id_vehiculo;

    @Column(name = "motor",nullable = false)
    private  Integer motor;

    @Column(name = "chasis",nullable = false)
    private  Integer chasis;

    @Column(name = "patente",nullable = false)
    private   String patente;

    @Column(name="año",nullable = false)
    private Integer año;

    @JoinColumn(name = "fk_modelo")
    @ManyToOne(cascade=CascadeType.ALL)
    private Modelo modelo;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="vehiculo_medidasDeSeguridad",
            joinColumns = @JoinColumn(name="fk_vehiculo"),
            inverseJoinColumns = @JoinColumn(name = "fk_medidasDeSeguridad"))
    List<MedidaDeSeguridad> medidasDeSeguridad;

    public Integer getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Integer id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public Integer getMotor() {
        return motor;
    }

    public void setMotor(Integer motor) {
        this.motor = motor;
    }

    public Integer getChasis() {
        return chasis;
    }

    public void setChasis(Integer chasis) {
        this.chasis = chasis;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<MedidaDeSeguridad> getMedidasDeSeguridad() {
        return medidasDeSeguridad;
    }

    public void setMedidasDeSeguridad(List<MedidaDeSeguridad> medidasDeSeguridad) {
        this.medidasDeSeguridad = medidasDeSeguridad;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Vehiculo() {
    }
}
