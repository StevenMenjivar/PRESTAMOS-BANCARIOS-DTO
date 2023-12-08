package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.ClienteDTO;

@Deprecated
public class ClienteMapper {
public static ClienteDTO mapCliente (Cliente cliente){

    ClienteDTO dto =new ClienteDTO();
    dto.setId(cliente.getId());
    dto.setNombreCliente(cliente.getNombreCliente());
    dto.setApellidoCliente(cliente.getApellidoCliente());
    dto.setEdadCliente(cliente.getEdadCliente());
    dto.setSueldoLiquidoCliente(cliente.getSueldoLiquidoCliente());
    return dto;
    }
}
