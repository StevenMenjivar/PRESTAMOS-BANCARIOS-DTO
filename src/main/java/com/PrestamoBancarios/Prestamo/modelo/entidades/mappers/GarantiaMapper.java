package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.FiadorDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.GarantiaDTO;
@Deprecated
public class GarantiaMapper {
    public static GarantiaDTO mapGarantia (Garantia garantia){
        GarantiaDTO dto =new GarantiaDTO();
        dto.setId(garantia.getId());
        dto.setDescripcionGarantia(garantia.getDescripcionGarantia());
        return dto;
    }
}
