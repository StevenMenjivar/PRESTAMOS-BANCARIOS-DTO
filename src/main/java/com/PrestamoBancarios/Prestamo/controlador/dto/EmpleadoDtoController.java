package com.PrestamoBancarios.Prestamo.controlador.dto;

import com.PrestamoBancarios.Prestamo.exeption.BadRequestException;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.ClienteDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.EmpleadoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.ClienteMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.EmpleadoMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.ClienteMapperStruct;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.EmpleadoMapperStruct;
import com.PrestamoBancarios.Prestamo.servicios.contratos.ClienteDAO;
import com.PrestamoBancarios.Prestamo.servicios.contratos.EmpleadoDAO;
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
@RequestMapping("/empleados")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class EmpleadoDtoController {
    @Autowired
    private EmpleadoDAO empleadoDAO;
    @GetMapping

    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje= new HashMap<>();
        //clienteDAO.findAll(); --EXTRAER
        List<Empleado> empleados = (List<Empleado>) empleadoDAO.findAll();
        List<EmpleadoDTO> empleadoDTOS = empleados
                .stream()
                .map(EmpleadoMapper::mapEmpleado)
                .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",empleadoDTOS);

        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/{codigo}")
    public Empleado obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Empleado> oEmpleado = empleadoDAO.findById(id);
        if(!oEmpleado.isPresent()){
            throw new BadRequestException(String.format("El empleado con id %d no existe", id));
        }
        return oEmpleado.get();
    }
    @PostMapping
    public Empleado altaEmpleado(@RequestBody Empleado empleado){
        return empleadoDAO.save(empleado);
    }


    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado){
        Empleado empleadoUpdate = null;
        //clienteDAO.findByID(id); --extraer
        Optional<Empleado> oEmpleado = empleadoDAO.findById(id);
        if(!oEmpleado.isPresent()){
            throw new BadRequestException(String.format("El empleado con id %id no existe", id));
        }
        empleadoUpdate=oEmpleado.get();
        empleadoUpdate.setNombreEmpleado(empleado.getNombreEmpleado());
        empleadoUpdate.setApellidoEmpleado(empleado.getApellidoEmpleado());
        empleadoUpdate.setSucursal(empleado.getSucursal());
        return empleadoDAO.save(empleadoUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable Integer id){empleadoDAO.deleteById(id);
    }
}
