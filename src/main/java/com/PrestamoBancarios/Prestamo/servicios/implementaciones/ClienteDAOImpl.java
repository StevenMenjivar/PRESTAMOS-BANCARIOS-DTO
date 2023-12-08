package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Cliente;
import com.PrestamoBancarios.Prestamo.repositorios.ClienteRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteDAOImpl extends GenericoDAOImpl<Cliente, ClienteRepository> implements ClienteDAO {

    @Autowired
    public ClienteDAOImpl(@Qualifier("repositoriocliente")ClienteRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Cliente> findClienteByNombreClienteContains(String nombreCliente) {
        return repository.findClienteByNombreClienteContains(nombreCliente);
    }

    @Override
    public Iterable<Cliente> findClienteByEdadClienteBetween(Integer edadCliente,Integer edadCliente2) {

        return repository.findClienteByEdadClienteBetween(edadCliente, edadCliente2);
    }

    @Override
    public Iterable<Cliente> findClienteBySueldoLiquidoClienteAfter(Double sueldoLiquidoCliente) {

        return repository.findClienteBySueldoLiquidoClienteAfter(sueldoLiquidoCliente);
    }
}
