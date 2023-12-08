package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Fiador;
import com.PrestamoBancarios.Prestamo.repositorios.FiadorRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.FiadorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class FiadorDAOImpl extends GenericoDAOImpl<Fiador, FiadorRepository> implements FiadorDAO {

    @Autowired
    public FiadorDAOImpl(FiadorRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Fiador> findFiadorByNombreFiadorContains(String nombreFiador) {
        return repository.findFiadorByNombreFiadorContains(nombreFiador);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Fiador> findFiadorByNombreFiadorContainsIgnoreCase(String nombreFiador) {
        return repository.findFiadorByNombreFiadorContainsIgnoreCase(nombreFiador);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Fiador> findFiadorByApellidoFiadorContains(String apellidoFiador) {
        return repository.findFiadorByApellidoFiadorContains(apellidoFiador);
    }
}
