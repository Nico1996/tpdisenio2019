package com.utn.frsf.Gestores;

import com.utn.frsf.Controllers.AltaPolizaController;
import com.utn.frsf.DAO.*;
import com.utn.frsf.DTO.*;
import com.utn.frsf.Enums.EstadoPoliza;
import com.utn.frsf.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GestorPoliza {

    @Autowired
    private MarcaVehiculoDAO marcaVehiculoDAO;
    @Autowired
    private ModeloVehiculoDAO modeloVehiculoDAO;
    @Autowired
    private TipoDeCoberturaDAO tipoDeCoberturaDAO;
    @Autowired
    private PolizaDAO polizaDAO;
    @Autowired
    private ClienteDAO clienteDAO;
    @Autowired
    private LocalidadDAO localidadDAO;
    @Autowired
    private MedidasDeSeguridadDAO medidasDeSeguridadDAO;
    @Autowired SiniestrosFcDAO siniestrosFcDAO;


    @Autowired
    private AltaPolizaController altaPolizaController;

    public List<TipoCoberturaDTO> findAllTiposDeCobertura() {
        List<TipoCoberturaDTO> list = new ArrayList<>();
        for (TipoCobertura tc : tipoDeCoberturaDAO.findAll()) {
            TipoCoberturaDTO tipoCoberturaDTO = new TipoCoberturaDTO(tc.getId_cobertura(), tc.getTipoCobertura(), tc.getDescripcion(), tc.getFact_caract_tipo_cob());
            list.add(tipoCoberturaDTO);
        }

        return list;
    }

    public List<MarcaDTO> findAllMarcasVehiculo() {
        List<MarcaDTO> list = new ArrayList<>();
        for (Marca m : marcaVehiculoDAO.findAll()) {
            MarcaDTO marcaDTO = new MarcaDTO(m.getId_marca(), m.getNombre_marca());
            list.add(marcaDTO);
        }
        return list;
    }

    public List<ModeloDTO> findAllModelosVehiculo() {
        List<ModeloDTO> list = new ArrayList<>();
        for (Modelo m : modeloVehiculoDAO.findAll()) {
            ModeloDTO modeloDTO = new ModeloDTO(m.getId_modelo(), m.getMarca().getId_marca(), m.getNombre_modelo());
            list.add(modeloDTO);

        }
        return list;
    }

    public List<ModeloDTO> findAllModelosByIdMarca(Integer id_marca) {

        List<ModeloDTO> list = new ArrayList<>();
        for (Modelo m : modeloVehiculoDAO.findAllById_marca(id_marca)) {
            ModeloDTO modeloDTO = new ModeloDTO(m.getId_modelo(), m.getMarca().getId_marca(), m.getNombre_modelo());
            list.add(modeloDTO);
        }
        return list;
    }


    public void altaPoliza(PolizaDTO polizaDTO) {

        Poliza poliza = new Poliza();

        /*if(admin!polizaDAO.findById(polizaDTO.nro_poliza).equals(Optional.empty())){
            altaPolizaController.showError("La poliza ya se encuentra creada.");
        }*/
       // else {

            Vehiculo vehiculo = new Vehiculo();
            poliza.setNro_poliza(1);
            poliza.setEstadoPoliza(EstadoPoliza.GENERADA);
            poliza.setKm_año(polizaDTO.getKm_año());
            poliza.setFecha_inicioVigencia(polizaDTO.getFecha_inicio());
            poliza.setFecha_finVigencia(polizaDTO.getFecha_fin());
            poliza.setImporte_por_descuento(polizaDTO.getImporte_x_descuento());
            poliza.setMontoTotal_abonar(polizaDTO.getMonto_total());
            poliza.setSuma_asegurada(polizaDTO.getPremio());
            poliza.setFormaPago(polizaDTO.getFormaPago());
            poliza.setCliente(clienteDAO.findById(polizaDTO.getId_clienteDTO()).get());
            poliza.setLocalidad(localidadDAO.findById(polizaDTO.getLocalidad()).get());
            poliza.setUltimo_dia_pago(polizaDTO.getFecha_fin());
            poliza.setPremio(Float.valueOf(0));
            poliza.setSiniestrosFC(siniestrosFcDAO.findById(polizaDTO.getId_siniestros()).get());

            vehiculo.setChasis(polizaDTO.getVehiculoDTO().getChasis());
            vehiculo.setId_vehiculo(null);
            vehiculo.setAño(polizaDTO.getVehiculoDTO().getAño());
            vehiculo.setMotor(polizaDTO.getVehiculoDTO().getMotor());
            vehiculo.setPatente(polizaDTO.getVehiculoDTO().getPatente());
            vehiculo.setModelo(modeloVehiculoDAO.findById(polizaDTO.getVehiculoDTO().getId_modelo()).get());

            List<MedidaDeSeguridad> medidaDeSeguridadList = new ArrayList<>();

            for (Integer i : polizaDTO.getVehiculoDTO().getMedidas_id()) {
                medidaDeSeguridadList.add(medidasDeSeguridadDAO.findById(i).get());
            }
            vehiculo.setMedidasDeSeguridad(medidaDeSeguridadList);
            poliza.setVehiculo(vehiculo);

            List<Hijo> listHijos = new ArrayList<>();
            for (HijoDTO h : polizaDTO.getHijoDTOList()) {
                Hijo hijo = new Hijo(h.getSexo(), h.getEstado_civil(), h.getFecha_nacimiento());
                listHijos.add(hijo);
            }
            poliza.setListaHijos(listHijos);
            poliza.setTipoCobertura(tipoDeCoberturaDAO.findById(polizaDTO.getId_tipoCoberturaDTO()).get());

            List<Cuota> listCuotas = new ArrayList<>();
            for (CuotaDTO c : polizaDTO.getCuotaDTOList()) {
                Cuota cuota = new Cuota();
                cuota.setFecha_vencimiento(c.getFecha_vencimiento());
                cuota.setMonto(c.getMonto());
                listCuotas.add(cuota);
            }
            poliza.setCuotas(listCuotas);

            polizaDAO.save(poliza);

            altaPolizaController.notificarExito("La poliza se creo correctamente");
            altaPolizaController.volverDeConfirmacion();
       // }

    }
}

