package com.PrestamoBancarios.Prestamo.controlador.dto;

import com.PrestamoBancarios.Prestamo.exeption.BadRequestException;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.FiadorDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.GarantiaDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.FiadorMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.GarantiaMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.FiadorMapperStruct;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.GarantiaMapperStruct;
import com.PrestamoBancarios.Prestamo.servicios.contratos.FiadorDAO;
import com.PrestamoBancarios.Prestamo.servicios.contratos.GarantiaDAO;
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
@RequestMapping("/garantias")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class GarantiaDtoController {
    @Autowired
    private GarantiaDAO garantiaDAO;
    @Autowired
    private GarantiaMapperStruct mapper;
    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje= new HashMap<>();
        //clienteDAO.findAll(); --EXTRAER
        List<Garantia> garantias = (List<Garantia>) garantiaDAO.findAll();
        List<GarantiaDTO> garantiasDTOS = garantias
                .stream()
                .map(mapper::mapGarantia)
                .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",garantiasDTOS);

        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/{codigo}")
    public Garantia obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Garantia> oGarantia = garantiaDAO.findById(id);
        if(!oGarantia.isPresent()){
            throw new BadRequestException(String.format("La garantía con id %d no existe", id));
        }
        return oGarantia.get();
    }
    @PostMapping
    public Garantia altaGarantia(@RequestBody Garantia garantia){
        return garantiaDAO.save(garantia);
    }


    @PutMapping("/{id}")
    public Garantia actualizarGarantia(@PathVariable Integer id, @RequestBody Garantia garantia){
        Garantia garantiaUpdate = null;
        //clienteDAO.findByID(id); --extraer
        Optional<Garantia> oGarantia = garantiaDAO.findById(id);
        if(!oGarantia.isPresent()){
            throw new BadRequestException(String.format("La garantía con id %id no existe", id));
        }
        garantiaUpdate=oGarantia.get();
        garantiaUpdate.setDescripcionGarantia(garantia.getDescripcionGarantia());
        return garantiaDAO.save(garantiaUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarGarantia(@PathVariable Integer id){garantiaDAO.deleteById(id);
    }

}
