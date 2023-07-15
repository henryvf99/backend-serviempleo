package com.example.backendserviempleo.services.impl;

import com.example.backendserviempleo.exceptions.GeneralServiceException;
import com.example.backendserviempleo.exceptions.IncorrectResourceRequestException;
import com.example.backendserviempleo.exceptions.ResourceNotFoundException;
import com.example.backendserviempleo.models.Servicio;
import com.example.backendserviempleo.repositories.ServicioRepositorio;
import com.example.backendserviempleo.services.ServicioService;
import com.example.backendserviempleo.validators.ServicioValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepositorio servicioRepositorio;

    public ServicioServiceImpl(ServicioRepositorio servicioRepositorio) {
        this.servicioRepositorio = servicioRepositorio;
    }

    @Transactional
    public Servicio agregarServicio(Servicio servicio){
        try {
            ServicioValidator.validate(servicio);
            return servicioRepositorio.save(servicio);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public Servicio modificarServicio(Servicio servicio){
        ServicioValidator.validate(servicio);

        Servicio servicioActualizado = servicioRepositorio.findById(servicio.getId()).orElseThrow(() -> new ResourceNotFoundException("no existe el servicio"));

        servicioActualizado.setTitulo(servicio.getTitulo());
        servicioActualizado.setCosto(servicio.getCosto());
        servicioActualizado.setDescripcion(servicio.getDescripcion());

        return servicioRepositorio.save(servicioActualizado);

    }
    @Transactional(readOnly = true)
    public List<Servicio> listarServicios(){
        return servicioRepositorio.findAll();
    }

    @Transactional
    public List<Servicio> listarServiciosPorUsuario(Integer idusuario){
        return servicioRepositorio.findByIdusuario(idusuario);
    }

    @Transactional
    public void eliminarServicio(Long id){
        Servicio servicio = this.obtenerServicioPorId(id);
        servicioRepositorio.delete(servicio);
    }

    public Servicio obtenerServicioPorId(Long id){
        Optional<Servicio> servicio = servicioRepositorio.findById(id);
        return servicio.orElseThrow(() -> new ResourceNotFoundException("Servicio no found"));
    }

}
