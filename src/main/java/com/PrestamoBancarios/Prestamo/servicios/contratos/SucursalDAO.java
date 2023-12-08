package com.PrestamoBancarios.Prestamo.servicios.contratos;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Sucursal;

public interface SucursalDAO extends GenericoDAO<Sucursal>{
    Iterable<Sucursal> findSucursalByNombreSucursalContains(String nombreSucursal);
    Iterable<Sucursal> findSucursalByNombreSucursalContainsIgnoreCase(String nombreSucursal);
}
