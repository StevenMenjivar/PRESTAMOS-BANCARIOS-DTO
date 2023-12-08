package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Pago;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Prestamo;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.GarantiaDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PagoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDateTime;

@Mapper(componentModel="spring")
public interface PagoMapperStruct {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "montoPago",target = "montoPago"),
            @Mapping(source = "fechaPago",target = "fechaPago"),
            @Mapping(source = "prestamo",target = "prestamo")
    })
    PagoDTO mapPago(Pago pago);
}
