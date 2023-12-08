package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.Modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.Modelo.entidades.Prestamo;
import com.PrestamoBancarios.Prestamo.repositorios.EmpleadoRepository;
import com.PrestamoBancarios.Prestamo.repositorios.PrestamoRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.EmpleadoDAO;
import com.PrestamoBancarios.Prestamo.servicios.contratos.PrestamoDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.PrestamoBancarios.Prestamo.datos.DatosDummy.cliente02;
import static com.PrestamoBancarios.Prestamo.datos.DatosDummy.prestamo01;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PrestamoDAOImplTest {
    PrestamoDAO prestamoDAO;
    PrestamoRepository prestamoRepository;
    @BeforeEach
    void setUp() {
       prestamoRepository=mock(PrestamoRepository.class);
        prestamoDAO=new PrestamoDAOImpl(prestamoRepository);
    }
    @AfterEach
    void tearDown() {
        prestamoRepository.deleteAll();
    }


    @Test
    void findPrestamoByCuotasPagoPrestamoLike() {
        //given
        Integer cuota=48;
        when(prestamoRepository.findPrestamoByCuotasPagoPrestamoLike(cuota))
                .thenReturn(Arrays.asList(prestamo01(true)));
        //when
        //List<Cliente> expected=clienteDAO.findClienteByNombreClienteContains(nombreCliente);
        List<Prestamo> expected= (List<Prestamo>) prestamoDAO.findPrestamoByCuotasPagoPrestamoLike(cuota);
        //then
        assertThat(expected.get(0)).isEqualTo(prestamo01(true));

        //validando
        verify(prestamoRepository).findPrestamoByCuotasPagoPrestamoLike(cuota);

    }
}