package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers;

import com.PrestamoBancarios.Prestamo.modelo.entidades.*;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.ClienteDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PrestamoDTO;
@Deprecated
public class PrestamoMapper {
    public static PrestamoDTO mapPrestamo (Prestamo prestamo){

        PrestamoDTO dto =new PrestamoDTO();
        dto.setId(prestamo.getId());
        dto.setCantidadPrestamo(prestamo.getCantidadPrestamo());
        dto.setTasaInteresPrestamo(prestamo.getTasaInteresPrestamo());
        dto.setPlazoPagoPrestamo(prestamo.getPlazoPagoPrestamo());
        dto.setCuotasPagoPrestamo(prestamo.getCuotasPagoPrestamo());
        dto.setGarantia(prestamo.getGarantia());
        dto.setCliente(prestamo.getCliente());
        dto.setTipoPrestamo(prestamo.getTipoPrestamo());
        dto.setFiador(prestamo.getFiador());
        dto.setEmpleado(prestamo.getEmpleado());
        return dto;

    }
}
