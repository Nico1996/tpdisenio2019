package com.utn.frsf.DAO;

import com.utn.frsf.Model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadDAO extends JpaRepository<Localidad,Integer> {
    @Query(value="SELECT * FROM localidad WHERE fk_provincia=:id", nativeQuery = true)
    List<Localidad> findAllById_provincia(@Param("id") Integer id);
}
