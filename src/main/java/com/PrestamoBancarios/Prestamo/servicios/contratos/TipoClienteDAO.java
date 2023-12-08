package com.PrestamoBancarios.Prestamo.servicios.contratos;

import com.PrestamoBancarios.Prestamo.modelo.entidades.TipoCliente;

public interface TipoClienteDAO extends GenericoDAO<TipoCliente>{
    Iterable<TipoCliente> findTipoClienteByDescripcionTipoClienteContains(String descripcionTipoCliente);
    Iterable<TipoCliente> findTipoClienteByDescripcionTipoClienteContainsIgnoreCase(String descripcionTipoCliente);
}
