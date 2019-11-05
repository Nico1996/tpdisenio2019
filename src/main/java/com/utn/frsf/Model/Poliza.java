package com.utn.frsf.Model;

import com.utn.frsf.Enums.EstadoPoliza;
import com.utn.frsf.Enums.FormaPago;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="poliza")
public class Poliza {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="nro_poliza",nullable = false)
    private Integer nro_poliza;

    @Column(name="estado",nullable = false)
    @Enumerated(EnumType.STRING)
    private   EstadoPoliza estadoPoliza;

    @Column(name="suma_asegurada",nullable = false)
    private   Float suma_asegurada;

    @Column(name="km_año",nullable = false)
    private   Float km_año;

    @Column(name="fecha_inicioVigencia",nullable = false)
    private   Date fecha_inicioVigencia;

    @Column(name="fecha_finVigencia",nullable = false)
    private   Date fecha_finVigencia;

    @Column(name="forma_pago",nullable = false)
    @Enumerated(EnumType.STRING)
    private  FormaPago formaPago;

    @Column(name="premio",nullable = false)
    private  Float premio;

    @Column(name="importe_por_descuento", nullable = false)
    private Float importe_por_descuento;

    @Column(name = "ultimo_dia_pago",nullable = false)
    private Date ultimo_dia_pago;

    @Column(name = "montoTotal_abonar",nullable = false)
    private Float montoTotal_abonar;

    @OneToOne(cascade = CascadeType.ALL)
    private Poliza poliza_renovada;

    @OneToOne(cascade = CascadeType.ALL)
    private  Vehiculo vehiculo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_localidad")
    private Localidad localidad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cobertura")
    TipoCobertura tipoCobertura;

    @OneToMany
    private List<PolizaModificada> polizaModificada;



}
