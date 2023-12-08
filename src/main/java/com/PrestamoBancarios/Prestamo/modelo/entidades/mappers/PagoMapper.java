package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Pago;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.GarantiaDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PagoDTO;
@Deprecated
public class PagoMapper {
    public static PagoDTO mapPago (Pago pago){
        PagoDTO dto =new PagoDTO();
        dto.setId(pago.getId());
        dto.setMontoPago(pago.getMontoPago());
        dto.setFechaPago(pago.getFechaPago());
        dto.setPrestamo(pago.getPrestamo());
        return dto;
    }
}
