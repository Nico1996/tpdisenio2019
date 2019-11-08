package com.utn.frsf.Gestores;

import com.utn.frsf.DAO.ClienteDAO;
import com.utn.frsf.DTO.ClienteDTO;
import com.utn.frsf.Enums.TipoDocumento;
import com.utn.frsf.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestorCliente {
    @Autowired
    private ClienteDAO clienteDAO;


    public List<ClienteDTO> findAllClientes(Long nro_cliente, Long nro_documento, String apellido, String nombre, TipoDocumento tipoDocumento){

       List<ClienteDTO> listaClientesDTO = new ArrayList<>();
            for(Cliente c : clienteDAO.findAllByParametrosBuscador(apellido,nombre,nro_cliente,nro_documento,tipoDocumento.toString())){
                ClienteDTO clienteDTO = new ClienteDTO(c.getNro_documento(),c.getApellido(),c.getNombre(),c.getTipoDocumento(),c.getNro_cliente(),c.getId_cliente());
                clienteDTO.setCalle(c.getDireccion().getCalle());
                clienteDTO.setNumero(c.getDireccion().getNumero());
                listaClientesDTO.add(clienteDTO);
            }
            return listaClientesDTO;
        }
}
