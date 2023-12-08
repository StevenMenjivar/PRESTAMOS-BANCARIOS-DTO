package com.PrestamoBancarios.Prestamo.servicios.contratos;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;

public interface EmpleadoDAO extends GenericoDAO<Empleado>{
    Iterable<Empleado> findEmpleadoByNombreEmpleadoContains(String nombreEmpleado);
    Iterable<Empleado> findEmpleadoByNombreEmpleadoContainsIgnoreCase(String nombreEmpleado);
    Iterable<Empleado> findEmpleadoByApellidoEmpleadoContains(String apellidoEmpleado);

}
