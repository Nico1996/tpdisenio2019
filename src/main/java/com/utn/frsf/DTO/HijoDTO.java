package com.utn.frsf.DTO;

import com.utn.frsf.Enums.EstadoCivil;
import com.utn.frsf.Enums.Sexo;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class HijoDTO {
    public HijoDTO(Sexo sexo, Date fecha_nacimiento, EstadoCivil estado_civil) {
        this.sexo = sexo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estado_civil = estado_civil;
    }

    private Sexo sexo;
    private Date fecha_nacimiento;
    private EstadoCivil estado_civil;
    private SimpleStringProperty asd;

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public EstadoCivil getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(EstadoCivil estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getAsd() {
        return asd.get();
    }

    public SimpleStringProperty asdProperty() {
        return asd;
    }

    public void setAsd(String asd) {
        this.asd.set(asd);
    }
}
