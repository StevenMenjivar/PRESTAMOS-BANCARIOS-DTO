package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Pago;
import org.springframework.data.repository.CrudRepository;

public interface PagoRepository extends CrudRepository<Pago, Integer> {
    Iterable<Pago> findPagoByMontoPagoAfter (Double montoPago);
}
