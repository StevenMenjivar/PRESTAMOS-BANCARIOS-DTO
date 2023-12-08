package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.repositorios.EmpleadoRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoDAOImpl extends GenericoDAOImpl<Empleado, EmpleadoRepository> implements EmpleadoDAO {

    @Autowired
    public EmpleadoDAOImpl(EmpleadoRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Empleado> findEmpleadoByNombreEmpleadoContains(String nombreEmpleado) {
        return repository.findEmpleadoByNombreEmpleadoContains(nombreEmpleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Empleado> findEmpleadoByNombreEmpleadoContainsIgnoreCase(String nombreEmpleado) {
        return repository.findEmpleadoByNombreEmpleadoContainsIgnoreCase(nombreEmpleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Empleado> findEmpleadoByApellidoEmpleadoContains(String apellidoEmpleado) {
        return repository.findEmpleadoByApellidoEmpleadoContains(apellidoEmpleado);
    }
}

