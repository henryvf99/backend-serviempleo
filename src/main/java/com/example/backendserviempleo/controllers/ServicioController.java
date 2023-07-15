package com.example.backendserviempleo.controllers;

import com.example.backendserviempleo.models.Servicio;
import com.example.backendserviempleo.services.ServicioService;
import com.example.backendserviempleo.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Servicio>> agregarServicio(@RequestBody Servicio servicio){
        Servicio newServicio = servicioService.agregarServicio(servicio);
        return new WrapperResponse<Servicio>(true, "success", newServicio)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Servicio>> modificarServicio(@RequestBody Servicio servicio){
        Servicio servicioActualizado = servicioService.modificarServicio(servicio);
        return new WrapperResponse<Servicio>(true, "success", servicioActualizado)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Servicio>>> listarServicios(){
        List<Servicio> notas = servicioService.listarServicios();
        return new WrapperResponse<>(true, "success", notas).createResponse(HttpStatus.OK);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<List<Servicio>>> listarServiciosPorUsuario(@PathVariable("id") Integer iduser){
        List<Servicio> servicios = servicioService.listarServiciosPorUsuario(iduser);
        return new WrapperResponse<>(true, "success", servicios).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Servicio>> obtenerServicioPorId(@PathVariable("id") Long id){
        Servicio servicio = servicioService.obtenerServicioPorId(id);
        return new WrapperResponse<>(true, "success", servicio).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminarServicio(@PathVariable Long id){
        servicioService.eliminarServicio(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.NO_CONTENT);
    }

}
