package com.example.backendserviempleo.services;

import com.example.backendserviempleo.models.Contrato;

import java.util.List;

public interface ContratoService {

    public Contrato agregarContrato(Contrato nota);

    public Contrato modificarContrato(Contrato nota);

    public List<Contrato> listarContratos();

    public List<Contrato> listarContratosPorUsuario(Integer iduserc);

    public List<Contrato> listarContratosPorUsuarioServicio(Integer idusuario);

    public Contrato obtenerContratoPorId(Long id);

    public void eliminarContrato(Long id);

}
