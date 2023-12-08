package com.PrestamoBancarios.Prestamo.modelo.entidades.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
    private Integer id;
    private String NombreCliente;
    private String ApellidoCliente;
    private int EdadCliente;
    private String DuiCliente;
    private Double SueldoLiquidoCliente;
}
