package com.PrestamoBancarios.Prestamo.modelo.entidades.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GarantiaDTO {
    private Integer id;
    private String descripcionGarantia;
}
