package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.modelo.entidades.TipoCliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.TipoPrestamo;
import org.springframework.data.repository.CrudRepository;

public interface TipoPrestamoRepository extends CrudRepository<TipoPrestamo, Integer> {


    Iterable<TipoPrestamo> findTipoPrestamoByDescripcionTipoPrestamoContains(String descripcionTipoPrestamo);
    Iterable<TipoPrestamo> findTipoPrestamoByDescripcionTipoPrestamoContainsIgnoreCase(String descripcionTipoPrestamo);
}
