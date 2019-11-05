package com.utn.frsf.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medidasDeSeguridad")
public class MedidaDeSeguridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_medida_seguridad")
    private  Integer id_medida_seguridad;

    @Column(name = "descripcion",nullable = false)
    private  String descripcion;

    @Column(name = "fact_medidaSeguridad",nullable = false)
    private  Float fact_medidaSeguridad;

   /* @ManyToMany(mappedBy = "medidas")
    List<Vehiculo> vehiculos;*/


}
