package com.example.backendserviempleo.controllers;

import com.example.backendserviempleo.models.Rol;
import com.example.backendserviempleo.models.Servicio;
import com.example.backendserviempleo.models.Usuario;
import com.example.backendserviempleo.models.UsuarioRol;
import com.example.backendserviempleo.services.UsuarioService;
import com.example.backendserviempleo.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{

        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));

        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolID(2L);
        rol.setNombre("USER");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usuarioService.obtenerUsuario(username);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Usuario>> obtenerUsuarioPorId(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        return new WrapperResponse<>(true, "success", usuario).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

}
