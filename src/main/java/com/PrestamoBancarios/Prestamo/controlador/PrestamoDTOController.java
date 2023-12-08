package com.PrestamoBancarios.Prestamo.controlador;


import com.PrestamoBancarios.Prestamo.exeption.BadRequestException;
import com.PrestamoBancarios.Prestamo.modelo.entidades.Prestamo;
import com.PrestamoBancarios.Prestamo.servicios.contratos.PrestamoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Deprecated
@ConditionalOnProperty(prefix = "app",name = "controller.enable-dto",havingValue = "false")
@RestController
@RequestMapping("/prestamos")
public class PrestamoDTOController {
    private final PrestamoDAO prestamoDAO;

    @Autowired
    public PrestamoDTOController(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    @GetMapping
    public List<Prestamo> obtenerTodos(){
        List<Prestamo> prestamos = (List<Prestamo>) prestamoDAO.findAll();

        if (prestamos.isEmpty()){
            throw new BadRequestException("No existen prestamos");
        }
        return prestamos;
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
    public Prestamo altaCliente(@RequestBody Prestamo prestamo){
        return prestamoDAO.save(prestamo);
    }
}
