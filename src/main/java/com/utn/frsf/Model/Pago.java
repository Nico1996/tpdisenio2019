package com.utn.frsf.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer id_pago;

    @Column(name = "monto",nullable = false)
    private Float monto;

    @Column(name="fecha",nullable = false)
    private Date fecha;
}
