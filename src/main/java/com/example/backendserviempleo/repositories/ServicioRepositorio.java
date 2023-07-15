package com.example.backendserviempleo.repositories;

import com.example.backendserviempleo.models.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {

    List<Servicio> findByIdusuario(Integer idusuario);

}
