package com.utn.frsf.DAO;

import com.utn.frsf.Model.TipoCobertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeCoberturaDAO extends JpaRepository<TipoCobertura,Integer> {

}
