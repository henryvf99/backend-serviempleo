package com.example.backendserviempleo.repositories;

import com.example.backendserviempleo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

}