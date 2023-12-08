package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriocliente")
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    Iterable<Cliente> findClienteByNombreClienteContains(String nombreCliente);
    Iterable<Cliente> findClienteByEdadClienteBetween(Integer edadCliente,Integer edadCliente2 );
    Iterable<Cliente> findClienteBySueldoLiquidoClienteAfter(Double sueldoLiquidoCliente);
}
