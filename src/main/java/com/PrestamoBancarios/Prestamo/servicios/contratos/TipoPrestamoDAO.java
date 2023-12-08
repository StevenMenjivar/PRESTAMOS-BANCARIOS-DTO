package com.PrestamoBancarios.Prestamo.servicios.contratos;

import com.PrestamoBancarios.Prestamo.modelo.entidades.TipoPrestamo;

public interface TipoPrestamoDAO extends GenericoDAO<TipoPrestamo>{

    Iterable<TipoPrestamo> findTipoPrestamoByDescripcionTipoPrestamoContains(String descripcionTipoPrestamo);
    Iterable<TipoPrestamo> findTipoPrestamoByDescripcionTipoPrestamoContainsIgnoreCase(String descripcionTipoPrestamo);
}
