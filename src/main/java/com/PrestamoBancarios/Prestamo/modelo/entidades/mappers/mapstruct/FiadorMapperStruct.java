package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.EmpleadoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.FiadorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface FiadorMapperStruct {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "nombreFiador",target = "nombreFiador"),
            @Mapping(source = "apellidoFiador",target = "apellidoFiador"),
            @Mapping(source = "duiFiador",target = "duiFiador")
    })
    FiadorDTO mapFiador(Fiador fiador);
}
