package com.PrestamoBancarios.Prestamo.modelo.entidades.dto;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Prestamo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PagoDTO {
    private Integer id;
    private Double montoPago;
    private LocalDateTime fechaPago;
     private Prestamo prestamo;
}
