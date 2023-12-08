package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.modelo.entidades.TipoPrestamo;
import com.PrestamoBancarios.Prestamo.repositorios.TipoPrestamoRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.TipoPrestamoDAO;
import org.springframework.transaction.annotation.Transactional;

public class TipoPrestamoDAOImpl extends GenericoDAOImpl<TipoPrestamo, TipoPrestamoRepository> implements TipoPrestamoDAO {


    public TipoPrestamoDAOImpl(TipoPrestamoRepository repository) {
        super(repository);
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable<TipoPrestamo> findTipoPrestamoByDescripcionTipoPrestamoContains(String descripcionTipoPrestamo) {
        return repository.findTipoPrestamoByDescripcionTipoPrestamoContains(descripcionTipoPrestamo);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<TipoPrestamo> findTipoPrestamoByDescripcionTipoPrestamoContainsIgnoreCase(String descripcionTipoPrestamo) {
        return repository.findTipoPrestamoByDescripcionTipoPrestamoContainsIgnoreCase(descripcionTipoPrestamo);
    }
}
