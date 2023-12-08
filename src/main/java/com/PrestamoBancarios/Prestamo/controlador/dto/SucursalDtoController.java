package com.PrestamoBancarios.Prestamo.controlador.dto;

import com.PrestamoBancarios.Prestamo.exeption.BadRequestException;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Prestamo;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Sucursal;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PrestamoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.SucursalDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.PrestamoMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.SucursalMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.PrestamoMapperStruct;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.SucursalMapperStruct;
import com.PrestamoBancarios.Prestamo.servicios.contratos.PrestamoDAO;
import com.PrestamoBancarios.Prestamo.servicios.contratos.SucursalDAO;
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
@RequestMapping("/sucursales")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class SucursalDtoController {
    @Autowired
    private SucursalDAO sucursalDAO;
    @Autowired
    private SucursalMapperStruct mapper;
    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje= new HashMap<>();
        //clienteDAO.findAll(); --EXTRAER
        List<Sucursal> sucursales = (List<Sucursal>) sucursalDAO.findAll();
        List<SucursalDTO> sucursalDTOS =sucursales
                .stream()
                .map(mapper::mapSucursal)
                .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",sucursalDTOS);

        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/{codigo}")
    public Sucursal obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Sucursal> oSucursal = sucursalDAO.findById(id);
        if(!oSucursal.isPresent()){
            throw new BadRequestException(String.format("La sucursal con id %d no existe", id));
        }
        return oSucursal.get();
    }
    @PostMapping
    public Sucursal altaSucursal(@RequestBody Sucursal sucursal){
        return sucursalDAO.save(sucursal);
    }


    @PutMapping("/{id}")
    public Sucursal actualizarSucursal(@PathVariable Integer id, @RequestBody Sucursal sucursal){
        Sucursal sucursalUpdate = null;
        //clienteDAO.findByID(id); --extraer
        Optional<Sucursal> oSucursal = sucursalDAO.findById(id);
        if(!oSucursal.isPresent()){
            throw new BadRequestException(String.format("La sucursal con id %id no existe", id));
        }
        sucursalUpdate=oSucursal.get();
        sucursalUpdate.setNombreSucursal(sucursal.getNombreSucursal());
        sucursalUpdate.setUbicacionSucursal(sucursal.getUbicacionSucursal());
        return sucursalDAO.save(sucursalUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarSucursal(@PathVariable Integer id){sucursalDAO.deleteById(id);
    }


}
