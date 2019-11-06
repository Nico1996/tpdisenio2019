package com.utn.frsf.Model;

import com.utn.frsf.Enums.*;

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

    @Column(name = "nro_cliente",nullable = false)
    private Long nro_cliente;

    @Column(name = "nro_documento", nullable = false)
    private Long nro_documento;

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

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getCuil_cuit() {
        return cuil_cuit;
    }

    public void setCuil_cuit(Long cuil_cuit) {
        this.cuil_cuit = cuil_cuit;
    }

    public CondicionIva getCondicionIva() {
        return condicionIva;
    }

    public void setCondicionIva(CondicionIva condicionIva) {
        this.condicionIva = condicionIva;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad_siniestro() {
        return cantidad_siniestro;
    }

    public void setCantidad_siniestro(Integer cantidad_siniestro) {
        this.cantidad_siniestro = cantidad_siniestro;
    }

    public EstadoCliente getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(EstadoCliente estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Integer getAño_registro() {
        return año_registro;
    }

    public void setAño_registro(Integer año_registro) {
        this.año_registro = año_registro;
    }
}
