package com.utn.frsf.DAO;

import com.utn.frsf.Model.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaDAO extends JpaRepository<Provincia,Integer> {
}
