package com.utn.frsf.Model;

import com.utn.frsf.Enums.EstadoPoliza;
import com.utn.frsf.Enums.FormaPago;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="poliza")
public class Poliza {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="nro_poliza")
    private Integer nro_poliza;

    @Column(name="estado",nullable = false)
    @Enumerated(EnumType.STRING)
    private   EstadoPoliza estadoPoliza;

    @Column(name="suma_asegurada",nullable = false)
    private   Float suma_asegurada;

    @Column(name="km_año",nullable = false)
    private   Float km_año;

    @Column(name="fecha_inicioVigencia",nullable = false)
    private Date fecha_inicioVigencia;

    @Column(name="fecha_finVigencia",nullable = false)
    private   Date fecha_finVigencia;

    @Column(name="forma_pago",nullable = false)
    @Enumerated(EnumType.STRING)
    private  FormaPago formaPago;

    @Column(name="premio")
    private  Float premio;

    @Column(name="importe_por_descuento", nullable = false)
    private Float importe_por_descuento;

    @Column(name = "ultimo_dia_pago")
    private Date ultimo_dia_pago;

    @Column(name = "montoTotal_abonar",nullable = false)
    private Float montoTotal_abonar;

    @OneToOne(cascade = CascadeType.ALL)
    private Poliza poliza_renovada;

    @OneToOne(cascade = CascadeType.ALL)
    private  Vehiculo vehiculo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_poliza")
    private List<Hijo> listaHijos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_cliente")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_localidad")
    private Localidad localidad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cobertura")
    private TipoCobertura tipoCobertura;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_poliza")
    private List<PolizaModificada> polizaModificada;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ajustesPorKm")
    private AjustesPorKM ajustesPorKM;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_siniestro")
    private SiniestrosFC siniestrosFC;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_factor_caracteristica")
    private FactoresCaracteristicas factoresCaracteristicas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_poliza")
    private List<Cuota> cuotas;

    public Integer getNro_poliza() {
        return nro_poliza;
    }

    public void setNro_poliza(Integer nro_poliza) {
        this.nro_poliza = nro_poliza;
    }

    public EstadoPoliza getEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(EstadoPoliza estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public Float getSuma_asegurada() {
        return suma_asegurada;
    }

    public void setSuma_asegurada(Float suma_asegurada) {
        this.suma_asegurada = suma_asegurada;
    }

    public Float getKm_año() {
        return km_año;
    }

    public void setKm_año(Float km_año) {
        this.km_año = km_año;
    }

    public Date getFecha_inicioVigencia() {
        return fecha_inicioVigencia;
    }

    public void setFecha_inicioVigencia(Date fecha_inicioVigencia) {
        this.fecha_inicioVigencia = fecha_inicioVigencia;
    }

    public Date getFecha_finVigencia() {
        return fecha_finVigencia;
    }

    public void setFecha_finVigencia(Date fecha_finVigencia) {
        this.fecha_finVigencia = fecha_finVigencia;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Float getPremio() {
        return premio;
    }

    public void setPremio(Float premio) {
        this.premio = premio;
    }

    public Float getImporte_por_descuento() {
        return importe_por_descuento;
    }

    public void setImporte_por_descuento(Float importe_por_descuento) {
        this.importe_por_descuento = importe_por_descuento;
    }

    public Date getUltimo_dia_pago() {
        return ultimo_dia_pago;
    }

    public void setUltimo_dia_pago(Date ultimo_dia_pago) {
        this.ultimo_dia_pago = ultimo_dia_pago;
    }

    public Float getMontoTotal_abonar() {
        return montoTotal_abonar;
    }

    public void setMontoTotal_abonar(Float montoTotal_abonar) {
        this.montoTotal_abonar = montoTotal_abonar;
    }

    public Poliza getPoliza_renovada() {
        return poliza_renovada;
    }

    public void setPoliza_renovada(Poliza poliza_renovada) {
        this.poliza_renovada = poliza_renovada;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public TipoCobertura getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(TipoCobertura tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public List<PolizaModificada> getPolizaModificada() {
        return polizaModificada;
    }

    public void setPolizaModificada(List<PolizaModificada> polizaModificada) {
        this.polizaModificada = polizaModificada;
    }

    public AjustesPorKM getAjustesPorKM() {
        return ajustesPorKM;
    }

    public void setAjustesPorKM(AjustesPorKM ajustesPorKM) {
        this.ajustesPorKM = ajustesPorKM;
    }

    public SiniestrosFC getSiniestrosFC() {
        return siniestrosFC;
    }

    public void setSiniestrosFC(SiniestrosFC siniestrosFC) {
        this.siniestrosFC = siniestrosFC;
    }

    public FactoresCaracteristicas getFactoresCaracteristicas() {
        return factoresCaracteristicas;
    }

    public void setFactoresCaracteristicas(FactoresCaracteristicas factoresCaracteristicas) {
        this.factoresCaracteristicas = factoresCaracteristicas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Hijo> getListaHijos() {
        return listaHijos;
    }

    public void setListaHijos(List<Hijo> listaHijos) {
        this.listaHijos = listaHijos;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public Poliza() {
    }
}
