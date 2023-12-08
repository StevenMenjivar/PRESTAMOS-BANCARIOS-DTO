package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.Modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.Modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.datos.DatosDummy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteRepositoryTest {
    @Autowired
    ClienteRepository clienteRepository;
    @BeforeEach
    void setUp(){
        clienteRepository.save(DatosDummy.cliente01(false));
        clienteRepository.save(DatosDummy.cliente02(false));
        clienteRepository.save(DatosDummy.cliente03(false));

    }

    @AfterEach
    void tearDown() {
        clienteRepository.deleteAll();
    }

    @Test
    @DisplayName("Buscar cliente por nombre")
    void findClienteByNombreClienteContains() {
        //given

        //when
        Iterable<Cliente> expected = clienteRepository.findClienteByNombreClienteContains("Juan");

        //then
        assertThat(((List<Cliente>)expected).size() == 1).isTrue();
    }


    @Test
    void findClienteByEdadClienteBetween() {
        //given

        //when
        Iterable<Cliente> expected = clienteRepository.findClienteByEdadClienteBetween(20,50);

        //then
        assertThat(((List<Cliente>)expected).size() == 3).isTrue();
    }

    @Test
    void findClienteBySueldoLiquidoClienteAfter() {
        //given

        //when
        Iterable<Cliente> expected = clienteRepository.findClienteBySueldoLiquidoClienteAfter (1000.0);

        //then
        assertThat(((List<Cliente>)expected).size() == 2).isTrue();
    }
}