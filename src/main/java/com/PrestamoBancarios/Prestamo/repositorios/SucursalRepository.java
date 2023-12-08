package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Sucursal;
import org.springframework.data.repository.CrudRepository;

public interface SucursalRepository extends CrudRepository<Sucursal, Integer> {

    Iterable<Sucursal> findSucursalByNombreSucursalContains(String nombreSucursal);
    Iterable<Sucursal> findSucursalByNombreSucursalContainsIgnoreCase(String nombreSucursal);
}
