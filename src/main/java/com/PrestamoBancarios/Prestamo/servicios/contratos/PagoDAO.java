package com.PrestamoBancarios.Prestamo.servicios.contratos;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Pago;

public interface PagoDAO extends GenericoDAO<Pago>{
    Iterable<Pago> findPagoByMontoPagoAfter (Double montoPago);

}
