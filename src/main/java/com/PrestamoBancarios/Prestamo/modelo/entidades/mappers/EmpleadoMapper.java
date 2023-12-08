package com.PrestamoBancarios.Prestamo.modelo.entidades.mappers;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Sucursal;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.ClienteDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.EmpleadoDTO;

public class EmpleadoMapper {
    public static EmpleadoDTO mapEmpleado (Empleado empleado){

        EmpleadoDTO dto =new EmpleadoDTO();
        dto.setId(empleado.getId());
        dto.setNombreEmpleado(empleado.getNombreEmpleado());
        dto.setApellidoEmpleado(empleado.getApellidoEmpleado());
        dto.setSucursal(empleado.getSucursal());
        return dto;

    }
}
