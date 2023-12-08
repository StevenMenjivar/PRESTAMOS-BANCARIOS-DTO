package com.PrestamoBancarios.Prestamo.servicios.contratos;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;

public interface FiadorDAO extends GenericoDAO<Fiador>{

    Iterable<Fiador> findFiadorByNombreFiadorContains(String nombreFiador);
    Iterable<Fiador> findFiadorByNombreFiadorContainsIgnoreCase(String nombreFiador);
    Iterable<Fiador> findFiadorByApellidoFiadorContains(String apellidoFiador);

}
