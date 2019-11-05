package com.utn.frsf.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipo_cobertura_modif")
public class TipoCoberturaModif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cobertura_modif")
    private Integer id_cobertura_modif;

    @Column(name= "nombre_cobertura",nullable = false)
    private String tipoCobertura;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "fact_caract_tipo_cob",nullable = false)
    private Float fact_caract_tipo_cob;

    @ManyToOne
    @JoinColumn(name = "fk_polizaModif")
    private PolizaModificada polizaModificada;

}
