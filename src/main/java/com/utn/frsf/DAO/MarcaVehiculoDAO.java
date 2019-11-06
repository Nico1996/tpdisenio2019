package com.utn.frsf.DAO;

import com.utn.frsf.Model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaVehiculoDAO extends JpaRepository<Marca,Integer> {
}
