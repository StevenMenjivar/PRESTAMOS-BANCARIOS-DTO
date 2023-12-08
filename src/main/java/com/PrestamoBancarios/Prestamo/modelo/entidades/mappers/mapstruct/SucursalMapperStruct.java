package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Prestamo;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Sucursal;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PrestamoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.SucursalDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface SucursalMapperStruct {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "nombreSucursal",target = "nombreSucursal"),
            @Mapping(source = "ubicacionSucursal",target = "ubicacionSucursal")


    })
    SucursalDTO mapSucursal(Sucursal sucursal);
}
