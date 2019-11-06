package com.utn.frsf.DAO;

import com.utn.frsf.Model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModeloVehiculoDAO extends JpaRepository<Modelo,Integer> {

    @Query(value="SELECT * FROM modelo WHERE id_marca=:id", nativeQuery = true)
    List<Modelo> findAllById_marca(@Param("id") Integer id);

}
