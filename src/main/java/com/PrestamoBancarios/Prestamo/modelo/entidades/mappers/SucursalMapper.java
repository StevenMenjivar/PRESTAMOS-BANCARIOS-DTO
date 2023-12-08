package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Pago;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Sucursal;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PagoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.SucursalDTO;
@Deprecated
public class SucursalMapper {
    public static SucursalDTO mapSucursal (Sucursal sucursal){
        SucursalDTO dto =new SucursalDTO();
        dto.setId(sucursal.getId());
        dto.setNombreSucursal(sucursal.getNombreSucursal());
        dto.setUbicacionSucursal(sucursal.getUbicacionSucursal());
        return dto;
    }
}
