package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.EmpleadoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.FiadorDTO;
@Deprecated
public class FiadorMapper {
    public static FiadorDTO mapFiador (Fiador fiador){

        FiadorDTO dto =new FiadorDTO();
        dto.setId(fiador.getId());
        dto.setNombreFiador(fiador.getNombreFiador());
        dto.setApellidoFiador(fiador.getApellidoFiador());
        dto.setDuiFiador(fiador.getDuiFiador());
        return dto;

    }
}
