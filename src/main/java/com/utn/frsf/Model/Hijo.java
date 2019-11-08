package com.utn.frsf.Model;

import com.utn.frsf.Enums.EstadoCivil;
import com.utn.frsf.Enums.Sexo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hijo")
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hijo")
    private Integer id_hijo;

    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "estado_civil")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;

    public Hijo(Sexo sexo, EstadoCivil estadoCivil, Date fecha_nacimiento) {
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Hijo() {
    }

    public Integer getId_hijo() {
        return id_hijo;
    }

    public void setId_hijo(Integer id_hijo) {
        this.id_hijo = id_hijo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
