package com.utn.frsf.Gestores;

import com.utn.frsf.DAO.ClienteDAO;
import com.utn.frsf.Enums.TipoDocumento;
import com.utn.frsf.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorCliente {
    @Autowired
    private ClienteDAO clienteDAO;

    public List<Cliente> findAllClientes(Long nro_cliente, Long nro_documento, String apellido, String nombre, TipoDocumento tipoDocumento){
            return clienteDAO.findAllBy(apellido,nombre,nro_cliente,nro_documento,tipoDocumento.toString());
        }
}
