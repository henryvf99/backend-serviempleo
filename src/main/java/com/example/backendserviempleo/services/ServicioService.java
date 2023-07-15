package com.example.backendserviempleo.services;

import com.example.backendserviempleo.models.Servicio;

import java.util.List;

public interface ServicioService {

    public Servicio agregarServicio(Servicio servicio);

    public Servicio modificarServicio(Servicio servicio);

    public List<Servicio> listarServicios();

    public List<Servicio> listarServiciosPorUsuario(Integer idusuario);

    public Servicio obtenerServicioPorId(Long id);

    public void eliminarServicio(Long id);

}
