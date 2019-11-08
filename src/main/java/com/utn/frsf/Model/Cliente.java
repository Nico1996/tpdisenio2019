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

    @Column(name = "tipo_dni")
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "cuit_cuil")
    private Long cuil_cuit;

    @Column(name = "nro_cliente")
    private Integer nro_cliente;

    @Column(name = "nro_documento")
    private Long nro_documento;

    @Column(name = "condicion_iva")
    @Enumerated(EnumType.STRING)
    private CondicionIva condicionIva;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad_siniestros")
    private Integer cantidad_siniestro;

    @Column(name = "estado_cliente")
    @Enumerated(EnumType.STRING)
    private EstadoCliente estadoCliente;

    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "mail")
    private String mail;

    @Column(name = "estado_civil")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column(name = "profesion")
    private String profesion;

    @Column(name="año_registro")
    private Integer año_registro;

    @ManyToOne
    @JoinColumn(name="fk_direccion")
    private Direccion direccion;

    @ManyToOne
    private Poliza poliza;

    public Poliza getPoliza() {
        return poliza;
    }

    public void setPoliza(Poliza poliza) {
        this.poliza = poliza;
    }


    public Cliente() {
    }

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

    public Integer getNro_cliente() {
        return nro_cliente;
    }

    public void setNro_cliente(Integer nro_cliente) {
        this.nro_cliente = nro_cliente;
    }

    public Long getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(Long nro_documento) {
        this.nro_documento = nro_documento;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
