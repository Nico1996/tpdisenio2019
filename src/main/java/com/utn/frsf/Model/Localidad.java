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

    @Override
    public String toString() {
        return nombre_localidad;
    }

    public Integer getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(Integer id_localidad) {
        this.id_localidad = id_localidad;
    }

    public String getNombre_localidad() {
        return nombre_localidad;
    }

    public void setNombre_localidad(String nombre_localidad) {
        this.nombre_localidad = nombre_localidad;
    }

    public Integer getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(Integer codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Float getFactor_localidad() {
        return factor_localidad;
    }

    public void setFactor_localidad(Float factor_localidad) {
        this.factor_localidad = factor_localidad;
    }
}
