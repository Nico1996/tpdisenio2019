package com.utn.frsf.DTO;

import java.util.List;

public class VehiculoDTO {
    private Integer id_vehiculo;
    private Integer chasis;
    private String patente;
    private Integer id_modelo;
    private List<MedidaDeSeguridadDTO> medidaDeSeguridadDTOList;
    private List<Integer> medidas_id;
    private String marca;
    private String modelo;
    private Integer motor;
    private Integer año;

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public List<Integer> getMedidas_id() {
        return medidas_id;
    }

    public void setMedidas_id(List<Integer> medidas_id) {
        this.medidas_id = medidas_id;
    }

    public Integer getMotor() {
        return motor;
    }

    public void setMotor(Integer motor) {
        this.motor = motor;
    }

    public List<MedidaDeSeguridadDTO> getMedidaDeSeguridadDTOList() {
        return medidaDeSeguridadDTOList;
    }

    public void setMedidaDeSeguridadDTOList(List<MedidaDeSeguridadDTO> medidaDeSeguridadDTOList) {
        this.medidaDeSeguridadDTOList = medidaDeSeguridadDTOList;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(Integer id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public Integer getChasis() {
        return chasis;
    }

    public void setChasis(Integer chasis) {
        this.chasis = chasis;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Integer getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Integer id_modelo) {
        this.id_modelo = id_modelo;
    }

    @Override
    public String toString() {
        return "VehiculoDTO{" +
                "id_vehiculo=" + id_vehiculo +
                ", chasis=" + chasis +
                ", patente='" + patente + '\'' +
                ", id_modelo=" + id_modelo +
                ", medidaDeSeguridadDTOList=" + medidaDeSeguridadDTOList +
                 ", id_medida" + medidas_id +
                '}';
    }
}
