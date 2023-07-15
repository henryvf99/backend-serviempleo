package com.example.backendserviempleo.services;

import com.example.backendserviempleo.models.Usuario;
import com.example.backendserviempleo.models.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuariosRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public Usuario obtenerUsuarioPorId(Long id);

    public void eliminarUsuario(Long usuarioId);

}
