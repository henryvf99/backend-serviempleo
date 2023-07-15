package com.example.backendserviempleo.services.impl;

import com.example.backendserviempleo.exceptions.ResourceNotFoundException;
import com.example.backendserviempleo.exceptions.UsuarioFoundException;
import com.example.backendserviempleo.models.Contrato;
import com.example.backendserviempleo.models.Usuario;
import com.example.backendserviempleo.models.UsuarioRol;
import com.example.backendserviempleo.repositories.RolRepositorio;
import com.example.backendserviempleo.repositories.UsuarioRepositorio;
import com.example.backendserviempleo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuariosRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepositorio.findByUsername(usuario.getUsername());
        if (usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }else{
            for (UsuarioRol usuarioRol:usuariosRoles){
                rolRepositorio.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuariosRoles);
            usuarioLocal = usuarioRepositorio.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepositorio.findByUsername(username);
    }

    public Usuario obtenerUsuarioPorId(Long id){
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        return usuario.orElseThrow(() -> new ResourceNotFoundException("Usuario no found"));
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepositorio.deleteById(usuarioId);
    }

}