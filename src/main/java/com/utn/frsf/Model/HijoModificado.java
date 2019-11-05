package com.utn.frsf.Model;

import com.utn.frsf.Enums.EstadoCivil;
import com.utn.frsf.Enums.Sexo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hijo_modificado")
public class HijoModificado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hijo_modif")
    private Integer id_hijo_modif;

    @Column(name = "sexo",nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "estado_civil")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column(name = "fecha_nacimiento",nullable = false)
    private Date fecha_nacimiento;

    @Column(name = "fecha_inicio_vigencia",nullable = false)
    private Date fecha_inicio_vigencia;

    @Column(name = "fecha_fin_vigencia",nullable = false)
    private Date fecha_fin_vigencia;
}
