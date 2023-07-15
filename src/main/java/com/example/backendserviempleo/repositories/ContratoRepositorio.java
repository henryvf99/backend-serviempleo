package com.example.backendserviempleo.repositories;

import com.example.backendserviempleo.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratoRepositorio extends JpaRepository<Contrato, Long> {

    List<Contrato> findByIduserc(Integer iduserc);

    List<Contrato> findByIdusuario(Integer idusuario);

}
