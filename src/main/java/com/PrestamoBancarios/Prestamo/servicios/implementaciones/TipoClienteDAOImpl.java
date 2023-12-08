package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.modelo.entidades.TipoCliente;
import com.PrestamoBancarios.Prestamo.repositorios.TipoClienteRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.TipoClienteDAO;
import org.springframework.transaction.annotation.Transactional;

public class TipoClienteDAOImpl extends GenericoDAOImpl<TipoCliente, TipoClienteRepository> implements TipoClienteDAO {


    public TipoClienteDAOImpl(TipoClienteRepository repository) {
        super(repository);
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable<TipoCliente> findTipoClienteByDescripcionTipoClienteContains(String descripcionTipoCliente) {
        return repository.findTipoClienteByDescripcionTipoClienteContains(descripcionTipoCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<TipoCliente> findTipoClienteByDescripcionTipoClienteContainsIgnoreCase(String descripcionTipoCliente) {
        return repository.findTipoClienteByDescripcionTipoClienteContainsIgnoreCase(descripcionTipoCliente);
    }
}
