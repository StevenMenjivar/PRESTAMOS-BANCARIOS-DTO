package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface ClienteMapperStruct {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "nombreCliente",target = "nombreCliente"),
            @Mapping(source = "apellidoCliente",target = "apellidoCliente"),
            @Mapping(source = "edadCliente",target = "edadCliente"),
            @Mapping(source = "duiCliente",target = "duiCliente"),
            @Mapping(source = "sueldoLiquidoCliente",target = "sueldoLiquidoCliente")
       //     @Mapping(source = "tipoClientes",target = "tipoClientes"),
    })



    ClienteDTO mapCliente(Cliente cliente);
}
