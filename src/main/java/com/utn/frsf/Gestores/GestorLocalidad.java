package com.utn.frsf.Gestores;

import com.utn.frsf.DAO.LocalidadDAO;
import com.utn.frsf.DAO.ProvinciaDAO;
import com.utn.frsf.Model.Localidad;
import com.utn.frsf.Model.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorLocalidad {


    @Autowired
    private LocalidadDAO localidadDAO;

    @Autowired
    private ProvinciaDAO provinciaDAO;

    public List<Localidad> getLocalidades(){
        return localidadDAO.findAll();
    }

    public List<Provincia> getProvincias(){
        return provinciaDAO.findAll();
    }

    public List<Localidad> getLocalidadesById_Provincia(Integer id_provincia){
        return localidadDAO.findAllById_provincia(id_provincia);
    }

}
