package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.repositorios.GarantiaRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.GarantiaDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GarantiaDAOImpl extends GenericoDAOImpl<Garantia, GarantiaRepository> implements GarantiaDAO {


    public GarantiaDAOImpl(GarantiaRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Garantia> findGarantiaByDescripcionGarantiaContains(String descripcinGarantia) {
        return repository.findGarantiaByDescripcionGarantiaContains(descripcinGarantia);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Garantia> findGarantiaByDescripcionGarantiaContainsIgnoreCase(String descripcinGarantia) {
        return repository.findGarantiaByDescripcionGarantiaContainsIgnoreCase(descripcinGarantia);
    }
}
