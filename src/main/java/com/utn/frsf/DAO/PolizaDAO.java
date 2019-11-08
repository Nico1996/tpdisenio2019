package com.utn.frsf.DAO;

import com.utn.frsf.Model.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizaDAO extends JpaRepository<Poliza,Integer> {

}
