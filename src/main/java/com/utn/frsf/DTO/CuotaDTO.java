package com.utn.frsf.DTO;

import java.util.Date;

public class CuotaDTO {
    private Date fecha_vencimiento;
    private Float monto;

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Fecha de vencimiento: "+this.fecha_vencimiento.toString()+"  -  "+"Monto: $"+this.monto.toString();
    }

    public CuotaDTO() {
    }
}
