package com.utn.frsf.DAO;

import com.utn.frsf.Enums.TipoDocumento;
import com.utn.frsf.Model.Cliente;
import com.utn.frsf.Model.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente,Integer> {
    @Query(value = "SELECT * FROM cliente WHERE apellido=:ap AND nombre=:nm AND nro_cliente=:nc AND nro_documento=:nd AND tipo_dni=:td", nativeQuery = true)
    List<Cliente> findAllByParametrosBuscador(@Param("ap") String ap, @Param("nm") String nm, @Param("nc") Long nc, @Param("nd") Long nd , @Param("td")String td);
}
