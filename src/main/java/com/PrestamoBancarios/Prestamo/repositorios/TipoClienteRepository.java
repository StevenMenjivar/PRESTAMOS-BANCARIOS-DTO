package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Sucursal;
import com.PrestamoBancarios.Prestamo.modelo.entidades.TipoCliente;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface TipoClienteRepository extends CrudRepository<TipoCliente, Integer> {

    Iterable<TipoCliente> findTipoClienteByDescripcionTipoClienteContains(String descripcionTipoCliente);
    Iterable<TipoCliente> findTipoClienteByDescripcionTipoClienteContainsIgnoreCase(String descripcionTipoCliente);
}
