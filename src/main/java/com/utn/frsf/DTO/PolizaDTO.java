package com.utn.frsf.DTO;

import com.utn.frsf.Enums.EstadoPoliza;
import com.utn.frsf.Enums.FormaPago;
import com.utn.frsf.Model.Cuota;

import java.util.Date;
import java.util.List;

public class PolizaDTO {
    private Integer id_clienteDTO;
    private List<HijoDTO> hijoDTOList;
    private VehiculoDTO vehiculoDTO;
    private Integer id_tipoCoberturaDTO;
    private Integer localidad;
    private Date fecha_inicio;
    private Date fecha_fin;
    private FormaPago formaPago;
    private Float premio;
    private Float importe_x_descuento;
    private Date ultimo_dia_pago;
    private Float monto_total;
    private Float km_año;
    private Integer id_siniestros;

    public Float getKm_año() {
        return km_año;
    }

    public void setKm_año(Float km_año) {
        this.km_año = km_año;
    }

    private List<CuotaDTO> cuotaDTOList;


    public PolizaDTO() {
    }

    public Integer getId_siniestros() {
        return id_siniestros;
    }

    public void setId_siniestros(Integer id_siniestros) {
        this.id_siniestros = id_siniestros;
    }

    public List<CuotaDTO> getCuotaDTOList() {
        return cuotaDTOList;
    }

    public void setCuotaDTOList(List<CuotaDTO> cuotaDTOList) {
        this.cuotaDTOList = cuotaDTOList;
    }

    public Integer getId_clienteDTO() {
        return id_clienteDTO;
    }

    public void setId_clienteDTO(Integer id_clienteDTO) {
        this.id_clienteDTO = id_clienteDTO;
    }

    public List<HijoDTO> getHijoDTOList() {
        return hijoDTOList;
    }

    public void setHijoDTOList(List<HijoDTO> hijoDTOList) {
        this.hijoDTOList = hijoDTOList;
    }

    public VehiculoDTO getVehiculoDTO() {
        return vehiculoDTO;
    }

    public void setVehiculoDTO(VehiculoDTO vehiculoDTO) {
        this.vehiculoDTO = vehiculoDTO;
    }

    public Integer getId_tipoCoberturaDTO() {
        return id_tipoCoberturaDTO;
    }

    public void setId_tipoCoberturaDTO(Integer id_tipoCoberturaDTO) {
        this.id_tipoCoberturaDTO = id_tipoCoberturaDTO;
    }

    public Integer getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Integer localidad) {
        this.localidad = localidad;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Float getPremio() {
        return premio;
    }

    public void setPremio(Float premio) {
        this.premio = premio;
    }

    public Float getImporte_x_descuento() {
        return importe_x_descuento;
    }

    public void setImporte_x_descuento(Float importe_x_descuento) {
        this.importe_x_descuento = importe_x_descuento;
    }

    public Date getUltimo_dia_pago() {
        return ultimo_dia_pago;
    }

    public void setUltimo_dia_pago(Date ultimo_dia_pago) {
        this.ultimo_dia_pago = ultimo_dia_pago;
    }

    public Float getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Float monto_total) {
        this.monto_total = monto_total;
    }

    @Override
    public String toString() {
        return "PolizaDTO{" +
                "clienteDTO=" + id_clienteDTO +
                ", hijoDTOList=" + hijoDTOList +
                ", vehiculoDTO=" + vehiculoDTO +
                ", id_tipoCoberturaDTO=" + id_tipoCoberturaDTO +
                ", localidad=" + localidad +
                ", fecha_inicio=" + fecha_inicio +
                ", fecha_fin=" + fecha_fin +
                ", formaPago=" + formaPago +
                ", premio=" + premio +
                ", importe_x_descuento=" + importe_x_descuento +
                ", ultimo_dia_pago=" + ultimo_dia_pago +
                ", monto_total=" + monto_total +
                '}';
    }
}
