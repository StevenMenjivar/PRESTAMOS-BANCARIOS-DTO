package com.PrestamoBancarios.Prestamo.controlador.dto;

import com.PrestamoBancarios.Prestamo.exeption.BadRequestException;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Prestamo;
import com.PrestamoBancarios.Prestamo.modelo.entidades.dto.ClienteDTO;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.ClienteMapper;
import com.PrestamoBancarios.Prestamo.modelo.entidades.mappers.mapstruct.ClienteMapperStruct;
import com.PrestamoBancarios.Prestamo.servicios.contratos.ClienteDAO;
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
@RequestMapping("/clientes")
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "true")
public class ClienteDtoController {
    @Autowired
    private ClienteDAO clienteDAO;
    @Autowired
    private ClienteMapperStruct mapper;
    @GetMapping

    public ResponseEntity<?> obtenerTodos(){
        Map<String, Object> mensaje= new HashMap<>();
        //clienteDAO.findAll(); --EXTRAER
        List<Cliente> clientes = (List<Cliente>) clienteDAO.findAll();
        List<ClienteDTO> clienteDTOS = clientes
                .stream()
                .map(mapper::mapCliente)
                .collect(Collectors.toList());
        mensaje.put("success",Boolean.TRUE);
        mensaje.put("data",clienteDTOS);

        return ResponseEntity.ok(mensaje);
    }
    @GetMapping("/{codigo}")
    public Cliente obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Cliente> oCliente = clienteDAO.findById(id);
        if(!oCliente.isPresent()){
            throw new BadRequestException(String.format("El cliente con id %d no existe", id));
        }
        return oCliente.get();
    }
    @PostMapping
    public Cliente altaCliente(@RequestBody Cliente cliente){
        return clienteDAO.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
        Cliente clienteUpdate = null;
        //clienteDAO.findByID(id); --extraer
        Optional<Cliente> oCliente = clienteDAO.findById(id);
        if(!oCliente.isPresent()){
            throw new BadRequestException(String.format("El cliente con id %id no existe", id));
        }
        clienteUpdate=oCliente.get();
        clienteUpdate.setNombreCliente(cliente.getNombreCliente());
        clienteUpdate.setApellidoCliente(cliente.getApellidoCliente());
        clienteUpdate.setEdadCliente(cliente.getEdadCliente());
        clienteUpdate.setSueldoLiquidoCliente(cliente.getSueldoLiquidoCliente());
        return clienteDAO.save(clienteUpdate);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Integer id){clienteDAO.deleteById(id);
    }


}
