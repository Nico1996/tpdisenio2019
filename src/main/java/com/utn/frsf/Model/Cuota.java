package com.utn.frsf.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="cuota")
public class Cuota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuota")
    private Integer id_cuota;

    @Column(name="fecha_vencimiento")
    private Date fecha_vencimiento;

    @Column(name="monto")
    private Float monto;

    @Column(name = "recargos")
    private Float recargos;

    @Column(name = "bonificacion_pago_adelantado")
    private Float bonificacion_pago_adelantado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_poliza")
    private Poliza poliza;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_pago")
    private Pago pago;



}
