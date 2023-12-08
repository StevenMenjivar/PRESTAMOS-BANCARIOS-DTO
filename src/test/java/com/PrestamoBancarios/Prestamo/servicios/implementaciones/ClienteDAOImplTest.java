package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.Modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.datos.DatosDummy;
import com.PrestamoBancarios.Prestamo.repositorios.ClienteRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.ClienteDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.PrestamoBancarios.Prestamo.datos.DatosDummy.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class
ClienteDAOImplTest {
    ClienteDAO clienteDAO;
    ClienteRepository clienteRepository;
    @BeforeEach
    void setUp() {
        clienteRepository=mock(ClienteRepository.class);
        clienteDAO=new ClienteDAOImpl(clienteRepository);
    }
    @AfterEach
    void tearDown() {
        clienteRepository.deleteAll();
    }

    @Test
    void findClienteByNombreClienteContains() {
        //given
        String nombreCliente="Pedro";
        when(clienteRepository.findClienteByNombreClienteContains(nombreCliente))
                .thenReturn(Arrays.asList(cliente02(true)));
        //when
        //List<Cliente> expected=clienteDAO.findClienteByNombreClienteContains(nombreCliente);
        List<Cliente> expected= (List<Cliente>) clienteDAO.findClienteByNombreClienteContains(nombreCliente);
        //then
        assertThat(expected.get(0)).isEqualTo(cliente02(true));

        //validando
        verify(clienteRepository).findClienteByNombreClienteContains(nombreCliente);

    }

    @Test
    void findClienteByEdadClienteBetween() {
        //given
        Integer edad1=20;
        Integer edad2=40;

        when(clienteRepository.findClienteByEdadClienteBetween (edad1,edad2))
                .thenReturn(Arrays.asList(cliente01(true)));
        //when
        //List<Cliente> expected=clienteDAO.findClienteByNombreClienteContains(nombreCliente);
        List<Cliente> expected= (List<Cliente>) clienteDAO.findClienteByEdadClienteBetween(edad1,edad2);
        //then
        assertThat(expected.get(0)).isEqualTo(cliente01(true));

        //validando
        verify(clienteRepository).findClienteByEdadClienteBetween(edad1,edad2);

    }

    @Test
    void findClienteBySueldoLiquidoClienteAfter() {
        //given
        Double sueldoLiquido=1000.00;
        when(clienteRepository.findClienteBySueldoLiquidoClienteAfter(sueldoLiquido))
                .thenReturn(Arrays.asList(cliente03(true)));
        //when
        //List<Cliente> expected=clienteDAO.findClienteByNombreClienteContains(nombreCliente);
        List<Cliente> expected= (List<Cliente>) clienteDAO.findClienteBySueldoLiquidoClienteAfter(sueldoLiquido);
        //then
        assertThat(expected.get(0)).isEqualTo(cliente03(true));

        //validando
        verify(clienteRepository).findClienteBySueldoLiquidoClienteAfter(sueldoLiquido);

    }



}