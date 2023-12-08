package com.PrestamoBancarios.Prestamo.repositorios;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrestamoRepository extends CrudRepository<Prestamo, Integer> {
    // Iterable<Prestamo> findPrestamoByClienteContainsIgnoreCase (Cliente cliente);
    @Query("SELECT p FROM Prestamo p JOIN p.cliente c WHERE c.nombreCliente = :nombre AND c.apellidoCliente = :apellido")
    Iterable<Prestamo> findByClienteNombreAndClienteApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
    @Query("SELECT p FROM Prestamo p WHERE p.cantidadPrestamo > :monto")
    Iterable<Prestamo> findByCantidadPrestamoGreaterThan(@Param("monto") Double monto);
    @Query("SELECT p FROM Prestamo p JOIN p.cliente c WHERE c.tipoClientes.descripcionTipoCliente = :tipoCliente")
    Iterable<Prestamo> findByDescripcionTipoCliente(@Param("tipoCliente") String tipoCliente);
    @Query("SELECT p FROM Prestamo p JOIN p.tipoPrestamo tp WHERE tp.descripcionTipoPrestamo = :tipoPrestamo")
    Iterable<Prestamo> findByDescripcionTipoPrestamo(@Param("tipoPrestamo") String tipoPrestamo);
    @Query("SELECT p FROM Prestamo p JOIN p.empleado e WHERE e.nombreEmpleado = :nombreEmpleado AND e.apellidoEmpleado = :apellidoEmpleado")
    Iterable<Prestamo> findByNombreApellidoEmpleado(@Param("nombreEmpleado") String nombreEmpleado, @Param("apellidoEmpleado") String apellidoEmpleado);

    @Query("SELECT p FROM Prestamo p JOIN p.empleado e JOIN e.sucursal s WHERE s.nombreSucursal = :nombreSucursal")
    Iterable<Prestamo> findByNombreSucursal(@Param("nombreSucursal") String nombreSucursal);

    Iterable<Prestamo> findPrestamoByTasaInteresPrestamoAfter(Double tasaInteresPrestamo);
    Iterable<Prestamo> findPrestamoByCuotasPagoPrestamoLike(Integer cuotasPagoPrestamo);
}
