package com.PrestamoBancarios.Prestamo.controlador.dto;

import com.PrestamoBancarios.Prestamo.exeption.BadRequestException;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Pago;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Prestamo;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.ClienteDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PrestamoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.ClienteMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.PrestamoMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.PagoMapperStruct;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.PrestamoMapperStruct;
import com.PrestamoBancarios.Prestamo.repositorios.PrestamoRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.ClienteDAO;
import com.PrestamoBancarios.Prestamo.servicios.contratos.PrestamoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prestamos")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class PrestamoDtoController {

    @Autowired
    private PrestamoDAO prestamoDAO;
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private PrestamoMapperStruct mapper;
    @GetMapping
    public ResponseEntity<?> obtenerTodos(
            @RequestParam(name = "nombreCliente", required = false) String nombreCliente,
            @RequestParam(name = "apellidoCliente", required = false) String apellidoCliente,
            @RequestParam(name = "montoPrestamo", required = false) Double montoPrestamo,
            @RequestParam(name = "tipoCliente", required = false) String tipoCliente,
            @RequestParam(name = "tipoPrestamo", required = false) String tipoPrestamo,
            @RequestParam(name = "nombreEmpleado", required = false) String nombreEmpleado,
            @RequestParam(name = "apellidoEmpleado", required = false) String apellidoEmpleado,
            @RequestParam(name = "nombreSucursal", required = false) String nombreSucursal) {

        Map<String, Object> mensaje = new HashMap<>();
        List<Prestamo> prestamos;

        //FILTRANDO POR
        if (nombreCliente != null && apellidoCliente != null) {
            prestamos = (List<Prestamo>) prestamoRepository.findByClienteNombreAndClienteApellido(nombreCliente, apellidoCliente);
        } else if (montoPrestamo != null) {
            prestamos = (List<Prestamo>) prestamoRepository.findByCantidadPrestamoGreaterThan(montoPrestamo);
        } else if (tipoCliente != null) {
            prestamos = (List<Prestamo>) prestamoRepository.findByDescripcionTipoCliente(tipoCliente);
        } else if (tipoPrestamo != null) {
            prestamos = (List<Prestamo>) prestamoRepository.findByDescripcionTipoPrestamo(tipoPrestamo);
        } else if (nombreEmpleado != null && apellidoEmpleado != null) {
            prestamos = (List<Prestamo>) prestamoRepository.findByNombreApellidoEmpleado(nombreEmpleado, apellidoEmpleado);
        } else if (nombreSucursal != null) {
            prestamos = (List<Prestamo>) prestamoRepository.findByNombreSucursal(nombreSucursal);
        } else {
            prestamos = (List<Prestamo>) prestamoRepository.findAll();
        }

        List<PrestamoDTO> prestamoDTOS = prestamos
                .stream()
                .map(PrestamoMapper::mapPrestamo)
                .collect(Collectors.toList());

        mensaje.put("success", Boolean.TRUE);
        mensaje.put("data", prestamoDTOS);

        return ResponseEntity.ok(mensaje);
    }

    @GetMapping("/{codigo}")
    public Prestamo obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Prestamo> oPrestamo = prestamoDAO.findById(id);
        if(!oPrestamo.isPresent()){
            throw new BadRequestException(String.format("El prestamo con id %d no existe", id));
        }
        return oPrestamo.get();
    }
    @PostMapping
    public Prestamo altaPrestamo(@RequestBody Prestamo prestamo){
        return prestamoDAO.save(prestamo);
    }

    @PutMapping("/{id}")
    public Prestamo actualizarPrestamo(@PathVariable Integer id, @RequestBody Prestamo prestamo){
        Prestamo prestamoUpdate = null;
        //clienteDAO.findByID(id); --extraer
        Optional<Prestamo> oPrestamo = prestamoDAO.findById(id);
        if(!oPrestamo.isPresent()){
            throw new BadRequestException(String.format("El prestamo con id %id no existe", id));
        }
        prestamoUpdate=oPrestamo.get();
        prestamoUpdate.setCantidadPrestamo(prestamo.getCantidadPrestamo());
        prestamoUpdate.setCuotasPagoPrestamo(prestamo.getCuotasPagoPrestamo());
        prestamoUpdate.setPlazoPagoPrestamo(prestamo.getPlazoPagoPrestamo());
        prestamoUpdate.setTipoPrestamo(prestamo.getTipoPrestamo());
        return prestamoDAO.save(prestamoUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarPrestamo(@PathVariable Integer id){prestamoDAO.deleteById(id);
    }


}
