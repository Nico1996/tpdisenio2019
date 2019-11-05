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

    @JoinColumn(name = "fk_modelo")
    @ManyToOne(cascade=CascadeType.ALL)
    private Modelo modelo;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="vehiculo_medidasDeSeguridad",
            joinColumns = @JoinColumn(name="fk_vehiculo"),
            inverseJoinColumns = @JoinColumn(name = "fk_medidasDeSeguridad"))
    List<MedidaDeSeguridad> medidasDeSeguridad;

}
