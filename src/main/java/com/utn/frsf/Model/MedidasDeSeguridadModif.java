package com.utn.frsf.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medidas_de_seguridad_modificada")
public class MedidasDeSeguridadModif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_medida_seguridad_modif")
    private  Integer id_medida_seguridad_modif;

    @Column(name = "descripcion",nullable = false)
    private  String descripcion;

    @Column(name = "fact_medidaSeguridad",nullable = false)
    private  Float fact_medidaSeguridad;

}
