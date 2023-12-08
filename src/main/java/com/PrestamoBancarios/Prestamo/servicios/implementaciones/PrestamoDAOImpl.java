package com.PrestamoBancarios.Prestamo.servicios.implementaciones;

import com.PrestamoBancarios.Prestamo.modelo.entidades.Prestamo;
import com.PrestamoBancarios.Prestamo.repositorios.PrestamoRepository;
import com.PrestamoBancarios.Prestamo.servicios.contratos.PrestamoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoDAOImpl extends GenericoDAOImpl<Prestamo, PrestamoRepository> implements PrestamoDAO {

    @Autowired
    public PrestamoDAOImpl(PrestamoRepository repository) {super(repository);}

    @Override
    public Iterable<Prestamo> findPrestamoByTasaInteresPrestamoAfter(Double tasaInteresPrestamo) {
        return repository.findPrestamoByTasaInteresPrestamoAfter(tasaInteresPrestamo);
    }

    @Override
    public Iterable<Prestamo> findPrestamoByCuotasPagoPrestamoLike(Integer cuotasPagoPrestamo) {
        return repository.findPrestamoByCuotasPagoPrestamoLike(cuotasPagoPrestamo);
    }
}

