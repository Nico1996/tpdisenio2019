package com.utn.frsf.Gestores;

import com.utn.frsf.DAO.LocalidadDAO;
import com.utn.frsf.DAO.ProvinciaDAO;
import com.utn.frsf.DTO.LocalidadDTO;
import com.utn.frsf.DTO.ProvinciaDTO;
import com.utn.frsf.Model.Localidad;
import com.utn.frsf.Model.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestorLocalidad {


    @Autowired
    private LocalidadDAO localidadDAO;

    @Autowired
    private ProvinciaDAO provinciaDAO;


    public List<ProvinciaDTO> getProvincias(){
        List<ProvinciaDTO> list = new ArrayList<>();
        for(Provincia p : provinciaDAO.findAll()){
            ProvinciaDTO provinciaDTO = new ProvinciaDTO(p.getId_provincia(),p.getNombre());
            list.add(provinciaDTO);
        }
        return list;
    }

    public List<LocalidadDTO> getLocalidadesById_Provincia(Integer id_provincia){
        List<LocalidadDTO> list = new ArrayList<>();
        for(Localidad l : localidadDAO.findAllById_provincia(id_provincia) ){
            LocalidadDTO localidadDTO = new LocalidadDTO(l.getId_localidad(),l.getNombre_localidad(),l.getFactor_localidad());
            list.add(localidadDTO);
        }
        return list;
    }





}
