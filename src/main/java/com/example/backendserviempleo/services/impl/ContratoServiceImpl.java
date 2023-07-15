package com.example.backendserviempleo.services.impl;

import com.example.backendserviempleo.exceptions.GeneralServiceException;
import com.example.backendserviempleo.exceptions.IncorrectResourceRequestException;
import com.example.backendserviempleo.exceptions.ResourceNotFoundException;
import com.example.backendserviempleo.models.Contrato;
import com.example.backendserviempleo.repositories.ContratoRepositorio;
import com.example.backendserviempleo.services.ContratoService;
import com.example.backendserviempleo.validators.ContratoValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ContratoServiceImpl implements ContratoService {

    private final ContratoRepositorio contratoRepositorio;

    public ContratoServiceImpl(ContratoRepositorio contratoRepositorio) {
        this.contratoRepositorio = contratoRepositorio;
    }

    @Transactional
    public Contrato agregarContrato(Contrato contrato){
        try {
            ContratoValidator.validate(contrato);
            return contratoRepositorio.save(contrato);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public Contrato modificarContrato(Contrato contrato){
        ContratoValidator.validate(contrato);

        Contrato contratoActualizado = contratoRepositorio.findById(contrato.getId()).orElseThrow(() -> new ResourceNotFoundException("no existe el contrato"));

        contratoActualizado.setNombre(contrato.getNombre());
        contratoActualizado.setApellido(contrato.getApellido());
        contratoActualizado.setTelefono(contrato.getTelefono());
        contratoActualizado.setDireccion(contrato.getDireccion());
        contratoActualizado.setMensaje(contrato.getMensaje());

        return contratoRepositorio.save(contratoActualizado);

    }
    @Transactional(readOnly = true)
    public List<Contrato> listarContratos(){
        return contratoRepositorio.findAll();
    }

    @Transactional
    public List<Contrato> listarContratosPorUsuario(Integer iduserc){
        return contratoRepositorio.findByIduserc(iduserc);
    }

    @Transactional
    public List<Contrato> listarContratosPorUsuarioServicio(Integer idusuario){
        return contratoRepositorio.findByIdusuario(idusuario);
    }

    @Transactional
    public void eliminarContrato(Long id){
        Contrato contrato = this.obtenerContratoPorId(id);
        contratoRepositorio.delete(contrato);
    }

    public Contrato obtenerContratoPorId(Long id){
        Optional<Contrato> contrato = contratoRepositorio.findById(id);
        return contrato.orElseThrow(() -> new ResourceNotFoundException("Contrato no found"));
    }

}
