package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.FiadorDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.GarantiaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface GarantiaMapperStruct {
    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "descripcionGarantia",target = "descripcionGarantia")
    })
    GarantiaDTO mapGarantia(Garantia garantia);
}
