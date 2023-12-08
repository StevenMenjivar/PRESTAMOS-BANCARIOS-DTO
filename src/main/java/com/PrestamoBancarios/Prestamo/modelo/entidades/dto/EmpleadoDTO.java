package com.PrestamoBancarios.Prestamo.modelo.entidades.dto;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Sucursal;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpleadoDTO {
    private Integer id;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private Sucursal sucursal;
}
