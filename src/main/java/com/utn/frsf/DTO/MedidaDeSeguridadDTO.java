package com.utn.frsf.DTO;

public class MedidaDeSeguridadDTO {
    String descripcion;

    public MedidaDeSeguridadDTO(String descripcion) {
        this.descripcion = descripcion;

    }

    @Override
    public String toString() {
        return "MedidaDeSeguridadDTO{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
