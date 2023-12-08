package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Pago;
import com.PrestamoBancarios.Prestamo.repositorios.GarantiaRepository;
import com.PrestamoBancarios.Prestamo.repositorios.PagoRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.GarantiaDAO;
import com.PrestamoBancarios.Prestamo.servicios.contratos.PagoDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PagoDAOImpl extends GenericoDAOImpl<Pago, PagoRepository> implements PagoDAO {


    public PagoDAOImpl(PagoRepository repository) {
        super(repository);
    }


    @Override
    public Iterable<Pago> findPagoByMontoPagoAfter(Double montoPago) {
        return repository.findPagoByMontoPagoAfter(montoPago);
    }
}

