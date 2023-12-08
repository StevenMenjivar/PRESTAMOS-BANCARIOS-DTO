package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct;

import com.PrestamoBancarios.Prestamo.modelo.entidades.*;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PagoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PrestamoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface PrestamoMapperStruct {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "cantidadPrestamo",target = "cantidadPrestamo"),
            @Mapping(source = "tasaInteresPrestamo",target = "tasaInteresPrestamo"),
            @Mapping(source = "plazoPagoPrestamo",target = "plazoPagoPrestamo"),
            @Mapping(source = "cuotasPagoPrestamo",target = "cuotasPagoPrestamo"),
            @Mapping(source = "garantia",target = "garantia"),
            @Mapping(source = "cliente",target = "cliente"),
            @Mapping(source = "tipoPrestamo",target = "tipoPrestamo"),
            @Mapping(source = "fiador",target = "fiador"),
            @Mapping(source = "empleado",target = "empleado"),

    })
    PrestamoDTO mapPrestamo(Prestamo prestamo);
}
