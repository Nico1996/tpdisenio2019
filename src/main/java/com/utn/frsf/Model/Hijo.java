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

    @Column(name = "sexo",nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "estado_civil")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column(name = "fecha_nacimiento",nullable = false)
    private Date fecha_nacimiento;
}
