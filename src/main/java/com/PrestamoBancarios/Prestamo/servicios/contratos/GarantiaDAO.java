package com.PrestamoBancarios.Prestamo.servicios.contratos;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;

public interface GarantiaDAO extends GenericoDAO<Garantia>{

    Iterable<Garantia> findGarantiaByDescripcionGarantiaContains(String descripcinGarantia);
    Iterable<Garantia> findGarantiaByDescripcionGarantiaContainsIgnoreCase(String descripcinGarantia);
}
