package com.PrestamoBancarios.Prestamo.modelo.entidades.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SucursalDTO {
    private Integer id;
    private String nombreSucursal;
    private String ubicacionSucursal;
}
