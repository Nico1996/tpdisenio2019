package com.utn.frsf.Enums;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id_cliente;

    @Column(name = "tipo_dni",nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "cuit_cuil", nullable = false)
    private Long cuil_cuit;

    @Column(name = "condicion_iva",nullable = false)
    @Enumerated(EnumType.STRING)
    private CondicionIva condicionIva;

    @Column(name = "apellido",nullable = false)
    private String apellido;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "cantidad_siniestros",nullable = false)
    private Integer cantidad_siniestro;

    @Column(name = "estado_cliente",nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoCliente estadoCliente;

    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "mail",nullable = false)
    private String mail;

    @Column(name = "estado_civil",nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column(name = "profesion",nullable = false)
    private String profesion;

    @Column(name="año_registro", nullable = false)
    private Integer año_registro;

}
