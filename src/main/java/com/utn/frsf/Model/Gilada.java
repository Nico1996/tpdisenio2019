package com.utn.frsf.Model;

import javax.persistence.*;

@Entity
@Table(name="gilada")
public class Gilada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gilada")
    private Integer id_gilada;

    @Column(name = "asd")
    private String asd;

    @OneToOne
    private User user;

    public Integer getId_gilada() {
        return id_gilada;
    }

    public void setId_gilada(Integer id_gilada) {
        this.id_gilada = id_gilada;
    }

    public String getAsd() {
        return asd;
    }

    public void setAsd(String asd) {
        this.asd = asd;
    }
}
