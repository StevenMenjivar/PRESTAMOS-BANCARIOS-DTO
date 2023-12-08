package com.PrestamoBancarios.Prestamo.controlador.dto;

import com.PrestamoBancarios.Prestamo.exeption.BadRequestException;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Garantia;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Pago;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.GarantiaDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.PagoDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.GarantiaMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.PagoMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.GarantiaMapperStruct;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.PagoMapperStruct;
import com.PrestamoBancarios.Prestamo.servicios.contratos.GarantiaDAO;
import com.PrestamoBancarios.Prestamo.servicios.contratos.PagoDAO;
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
@RequestMapping("/pagos")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class PagoDtoController {
    @Autowired
    private PagoDAO pagoDAO;
    @Autowired
    private PagoMapperStruct mapper;
    @GetMapping
    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje= new HashMap<>();
        //clienteDAO.findAll(); --EXTRAER
        List<Pago> pagos = (List<Pago>) pagoDAO.findAll();
        List<PagoDTO> pagosDTOS = pagos
                    .stream()
                .map(mapper::mapPago)
                .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",pagosDTOS);

        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/{codigo}")
    public Pago obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Pago> oPago = pagoDAO.findById(id);
        if(!oPago.isPresent()){
            throw new BadRequestException(String.format("El pago con id %d no existe", id));
        }
        return oPago.get();
    }
    @PostMapping
    public Pago altaPago(@RequestBody Pago pago){
        return pagoDAO.save(pago);
    }


    @PutMapping("/{id}")
    public Pago actualizarPago(@PathVariable Integer id, @RequestBody Pago pago){
        Pago pagoUpdate = null;
        //clienteDAO.findByID(id); --extraer
        Optional<Pago> oPago = pagoDAO.findById(id);
        if(!oPago.isPresent()){
            throw new BadRequestException(String.format("El pago con id %id no existe", id));
        }
        pagoUpdate=oPago.get();
        pagoUpdate.setMontoPago(pago.getMontoPago());
        pagoUpdate.setFechaPago(pago.getFechaPago());
        return pagoDAO.save(pagoUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable Integer id){pagoDAO.deleteById(id);
    }

}
