package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.Modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.Modelo.entidades.Prestamo;
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
class PrestamoRepositoryTest {
    @Autowired
    PrestamoRepository prestamoRepository;
    @BeforeEach
    void setUp(){
        prestamoRepository.save(DatosDummy.prestamo01(false));
        prestamoRepository.save(DatosDummy.prestamo02());
        prestamoRepository.save(DatosDummy.prestamo03());

    }

    @AfterEach
    void tearDown() {
       prestamoRepository.deleteAll();
    }

//    @Test
//    @DisplayName("Buscar préstamo por cliente")
//    void findPrestamoByClienteContainsIgnoreCase(){
//        //given
//
//        //when
//        Iterable<Prestamo> expected = prestamoRepository.findPrestamoByClienteContainsIgnoreCase(new Cliente(null,"Alex","Menendez",44,"05074312-0",1300.00));
//
//        //then
//        assertThat(((List<Prestamo>)expected).size() == 1).isTrue();
//    }

    @Test
    @DisplayName("Buscar préstamo por tasa de interés mayor a 13%")
    void findPrestamoByTasaInteresPrestamoAfter() {
        //given

        //when
        Iterable<Prestamo> expected = prestamoRepository.findPrestamoByTasaInteresPrestamoAfter(12.8);

        //then
        assertThat(((List<Prestamo>)expected).size() == 1).isTrue();
    }

    @Test
    @DisplayName("Buscar préstamo por cantidad de cuotas")
    void findPrestamoByCuotasPagoPrestamoLike() {
        //given

        //when
        Iterable<Prestamo> expected = prestamoRepository.findPrestamoByCuotasPagoPrestamoLike(48);

        //then
        assertThat(((List<Prestamo>)expected).size() == 1).isTrue();
    }
}