package com.PrestamoBancarios.Prestamo.controlador.dto;

import com.PrestamoBancarios.Prestamo.exeption.BadRequestException;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Empleado;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.EmpleadoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.FiadorDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.EmpleadoMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.FiadorMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.ClienteMapperStruct;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.FiadorMapperStruct;
import com.PrestamoBancarios.Prestamo.servicios.contratos.EmpleadoDAO;
import com.PrestamoBancarios.Prestamo.servicios.contratos.FiadorDAO;
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
@RequestMapping("/fiadores")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class FiadorDtoController {
    @Autowired
    private FiadorDAO fiadorDAO;
    @Autowired
    private FiadorMapperStruct mapper;
    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje= new HashMap<>();
        //clienteDAO.findAll(); --EXTRAER
        List<Fiador> fiadores = (List<Fiador>) fiadorDAO.findAll();
        List<FiadorDTO> fiadorDTOS = fiadores
                .stream()
                .map(mapper::mapFiador)
                .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",fiadorDTOS);

        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/{codigo}")
    public Fiador obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Fiador> oFiador = fiadorDAO.findById(id);
        if(!oFiador.isPresent()){
            throw new BadRequestException(String.format("El fiador con id %d no existe", id));
        }
        return oFiador.get();
    }
    @PostMapping
    public Fiador altaFiador(@RequestBody Fiador fiador){
        return fiadorDAO.save(fiador);
    }

    @PutMapping("/{id}")
    public Fiador actualizarFiador(@PathVariable Integer id, @RequestBody Fiador fiador){
        Fiador fiadorUpdate = null;
        //clienteDAO.findByID(id); --extraer
        Optional<Fiador> oFiador = fiadorDAO.findById(id);
        if(!oFiador.isPresent()){
            throw new BadRequestException(String.format("El fiador con id %id no existe", id));
        }
        fiadorUpdate=oFiador.get();
        fiadorUpdate.setNombreFiador(fiador.getNombreFiador());
        fiadorUpdate.setApellidoFiador(fiador.getApellidoFiador());
        return fiadorDAO.save(fiadorUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarFiador(@PathVariable Integer id){fiadorDAO.deleteById(id);
    }

}
