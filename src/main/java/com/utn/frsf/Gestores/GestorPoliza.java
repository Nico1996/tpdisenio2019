package com.utn.frsf.Gestores;

import com.utn.frsf.DAO.MarcaVehiculoDAO;
import com.utn.frsf.DAO.ModeloVehiculoDAO;
import com.utn.frsf.DAO.TipoDeCoberturaDAO;
import com.utn.frsf.DAO.VehiculoDAO;
import com.utn.frsf.DTO.MarcaDTO;
import com.utn.frsf.DTO.ModeloDTO;
import com.utn.frsf.DTO.TipoCoberturaDTO;
import com.utn.frsf.Model.Localidad;
import com.utn.frsf.Model.Marca;
import com.utn.frsf.Model.Modelo;
import com.utn.frsf.Model.TipoCobertura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestorPoliza {

    @Autowired
    private MarcaVehiculoDAO marcaVehiculoDAO;
    @Autowired
    private ModeloVehiculoDAO modeloVehiculoDAO;
    @Autowired
    private TipoDeCoberturaDAO tipoDeCoberturaDAO;

    public List<TipoCoberturaDTO> findAllTiposDeCobertura(){
        List<TipoCoberturaDTO> list = new ArrayList<>();
        for(TipoCobertura tc : tipoDeCoberturaDAO.findAll()){
            TipoCoberturaDTO tipoCoberturaDTO = new TipoCoberturaDTO(tc.getId_cobertura(),tc.getTipoCobertura(),tc.getDescripcion(),tc.getFact_caract_tipo_cob());
            list.add(tipoCoberturaDTO);
        }

        return list;
    }

    public List<MarcaDTO> findAllMarcasVehiculo(){
        List<MarcaDTO> list = new ArrayList<>();
        for(Marca m : marcaVehiculoDAO.findAll()){
            MarcaDTO marcaDTO = new MarcaDTO(m.getId_marca(),m.getNombre_marca());
            list.add(marcaDTO);
        }
        return list;
    }

    public List<ModeloDTO> findAllModelosVehiculo(){
        List<ModeloDTO> list = new ArrayList<>();
        for(Modelo m : modeloVehiculoDAO.findAll()){
            ModeloDTO modeloDTO = new ModeloDTO(m.getId_modelo(),m.getMarca().getId_marca(),m.getNombre_modelo());
            list.add(modeloDTO);

        }
        return list;
    }

    public List<ModeloDTO> findAllModelosByIdMarca(Integer id_marca){
        List<ModeloDTO> list = new ArrayList<>();
        for(Modelo m :  modeloVehiculoDAO.findAllById_marca(id_marca)){
            ModeloDTO modeloDTO = new ModeloDTO(m.getId_modelo(),m.getMarca().getId_marca(),m.getNombre_modelo());
            list.add(modeloDTO);
        }
        return list;
    }



}
