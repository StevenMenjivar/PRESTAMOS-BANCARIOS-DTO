package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface GarantiaRepository extends CrudRepository<Garantia, Integer> {

    Iterable<Garantia> findGarantiaByDescripcionGarantiaContains(String descripcinGarantia);
    Iterable<Garantia> findGarantiaByDescripcionGarantiaContainsIgnoreCase(String descripcinGarantia);

}
