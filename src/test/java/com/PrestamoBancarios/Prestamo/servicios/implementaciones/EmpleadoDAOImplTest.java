package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.Modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.Modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.repositorios.ClienteRepository;
import com.PrestamoBancarios.Prestamo.repositorios.EmpleadoRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.ClienteDAO;
import com.PrestamoBancarios.Prestamo.servicios.contratos.EmpleadoDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.PrestamoBancarios.Prestamo.datos.DatosDummy.cliente02;
import static com.PrestamoBancarios.Prestamo.datos.DatosDummy.empleado01;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpleadoDAOImplTest {

    EmpleadoDAO empleadoDAO;
    EmpleadoRepository empleadoRepository;
    @BeforeEach
    void setUp() {
        empleadoRepository=mock(EmpleadoRepository.class);
        empleadoDAO=new EmpleadoDAOImpl(empleadoRepository);
    }
    @AfterEach
    void tearDown() {
        empleadoRepository.deleteAll();
    }

    @Test
    void findEmpleadoByNombreEmpleadoContains() {

    }

    @Test
    void findEmpleadoByNombreEmpleadoContainsIgnoreCase() {
    }

    @Test
    void findEmpleadoByApellidoEmpleadoContains() {

    }
}