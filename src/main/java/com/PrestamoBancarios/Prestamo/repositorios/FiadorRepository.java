package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import org.springframework.data.repository.CrudRepository;

public interface FiadorRepository extends CrudRepository<Fiador, Integer> {

    Iterable<Fiador> findFiadorByNombreFiadorContains(String nombreFiador);
    Iterable<Fiador> findFiadorByNombreFiadorContainsIgnoreCase(String nombreFiador);
    Iterable<Fiador> findFiadorByApellidoFiadorContains(String apellidoFiador);
}
