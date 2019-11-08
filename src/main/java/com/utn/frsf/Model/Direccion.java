package com.utn.frsf.Model;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer id_direccion;

    @Column(name = "calle",nullable = false)
    private String calle;

    @Column(name = "numero",nullable = false)
    private String numero;

    @Column(name = "piso")
    private Integer piso;

    @Column(name="depto")
    private  String depto;

    @ManyToOne
    @JoinColumn(name="fk_localidad")
    private Localidad localidad;

    public Direccion(String calle, String numero, Integer piso, String depto, Localidad localidad) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.depto = depto;
        this.localidad = localidad;
    }

    public Direccion() {
    }

    public Integer getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Integer id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
