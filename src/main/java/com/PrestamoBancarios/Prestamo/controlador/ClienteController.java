package com.PrestamoBancarios.Prestamo.controlador;


import com.PrestamoBancarios.Prestamo.exeption.BadRequestException;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.servicios.contratos.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Deprecated
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "false")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteDAO clienteDAO;

    @Autowired
    public ClienteController(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @GetMapping
    public List<Cliente> obtenerTodos(){
        List<Cliente> clientes = (List<Cliente>) clienteDAO.findAll();

        if (clientes.isEmpty()){
            throw new BadRequestException("No existen carreras");
        }
        return clientes;
    }

    @GetMapping("/{codigo}")
    public Cliente obtenerPorId(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Cliente> oCarrera = clienteDAO.findById(id);
        if(!oCarrera.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe", id));
        }
        return oCarrera.get();
    }
    @PostMapping
    public Cliente altaCliente(@RequestBody Cliente cliente){
        return clienteDAO.save(cliente);
    }
}
