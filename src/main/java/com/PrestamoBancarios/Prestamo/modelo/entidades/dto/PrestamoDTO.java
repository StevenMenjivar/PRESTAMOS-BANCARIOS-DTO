package com.PrestamoBancarios.Prestamo.modelo.entidades.dto;

import com.PrestamoBancarios.Prestamo.modelo.entidades.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PrestamoDTO {
    private Integer id;
    private Double cantidadPrestamo;
    private Double tasaInteresPrestamo;
    private int plazoPagoPrestamo;
    private int cuotasPagoPrestamo;
    private Garantia garantia;
    private Cliente cliente;
    private TipoPrestamo tipoPrestamo;
    private Fiador fiador;
    private Empleado empleado;

}
