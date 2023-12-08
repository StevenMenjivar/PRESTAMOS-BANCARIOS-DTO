package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.Modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.datos.DatosDummy;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class EmpleadoRepositoryTest {
    @Autowired
    EmpleadoRepository empleadoRepository;
    @BeforeEach
    void setUp(){
        empleadoRepository.save(DatosDummy.empleado01(false));
        empleadoRepository.save(DatosDummy.empleado02(false));
        empleadoRepository.save(DatosDummy.empleado03());
    }

    @AfterEach
    void tearDown() {
        empleadoRepository.deleteAll();
    }
    @Test
    @DisplayName("Buscar empleados por nombre")
    void findEmpleadoByNombreEmpleadoContains() {
        //given

        //when
        Iterable<Empleado> expected = empleadoRepository.findEmpleadoByNombreEmpleadoContains("Mario");

        //then
        assertThat(((List<Empleado>)expected).size() == 1).isTrue();
    }

    @Test
    @DisplayName("Buscar empleados por nombre ingnorando case")
    void findEmpleadoByNombreEmpleadoContainsIgnoreCase() {
        //given

        //when
        Iterable<Empleado> expected = empleadoRepository.findEmpleadoByNombreEmpleadoContainsIgnoreCase("rodrigo");

        //then
        assertThat(((List<Empleado>)expected).size() == 1).isTrue();
    }

    @Test
    @DisplayName("Buscar empleados por Apellido")
    void findEmpleadoByApellidoEmpleadoContains() {
        //given

        //when
        Iterable<Empleado> expected = empleadoRepository.findEmpleadoByApellidoEmpleadoContains("Ruiz");

        //then
        assertThat(((List<Empleado>)expected).size() == 1).isTrue();

    }
}