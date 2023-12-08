package com.PrestamoBancarios.Prestamo.modelo.entidades.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FiadorDTO {
    private Integer id;
    private String nombreFiador;
    private String apellidoFiador;
    private String duiFiador;
}
