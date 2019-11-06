package com.utn.frsf.Gestores;

import com.utn.frsf.DAO.MarcaVehiculoDAO;
import com.utn.frsf.DAO.ModeloVehiculoDAO;
import com.utn.frsf.DAO.VehiculoDAO;
import com.utn.frsf.Model.Localidad;
import com.utn.frsf.Model.Marca;
import com.utn.frsf.Model.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorPoliza {

    @Autowired
    private MarcaVehiculoDAO marcaVehiculoDAO;
    @Autowired
    private ModeloVehiculoDAO modeloVehiculoDAO;

    public List<Marca> findAllMarcasVehiculo(){
        return marcaVehiculoDAO.findAll();
    }

    public List<Modelo> findAllModelosVehiculo(){
        return modeloVehiculoDAO.findAll();
    }

    public List<Modelo> findAllModelosByIdMarca(Integer id_marca){
        return modeloVehiculoDAO.findAllById_marca(id_marca);
    }



}
