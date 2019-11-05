package com.utn.frsf.Model;

import javax.persistence.*;

@Entity
@Table(name = "ajustes_por_km")
public class AjustesPorKM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ajustes")
    private Integer id_ajustes;

    @Column(name = "ajustes_por_km_realizados",nullable = false)
    private Float ajustes_por_km_realizados;

    @Column(name = "valor_inicial",nullable = false)
    private Float valor_inicial;

    @Column(name = "valor_fin",nullable = false)
    private Float valor_fin;



}
