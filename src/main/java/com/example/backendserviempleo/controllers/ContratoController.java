package com.example.backendserviempleo.controllers;

import com.example.backendserviempleo.models.Contrato;
import com.example.backendserviempleo.services.ContratoService;
import com.example.backendserviempleo.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    private ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Contrato>> agregarContrato(@RequestBody Contrato contrato){
        Contrato newContrato = contratoService.agregarContrato(contrato);
        return new WrapperResponse<Contrato>(true, "success", newContrato)
                .createResponse(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Contrato>> modificarContrato(@RequestBody Contrato contrato){
        Contrato contratoActualizado = contratoService.modificarContrato(contrato);
        return new WrapperResponse<Contrato>(true, "success", contratoActualizado)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<WrapperResponse<List<Contrato>>> listarContratos(){
        List<Contrato> contratos = contratoService.listarContratos();
        return new WrapperResponse<>(true, "success", contratos).createResponse(HttpStatus.OK);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<List<Contrato>>> listarContratosPorUsuario(@PathVariable("id") Integer iduserc){
        List<Contrato> contratos = contratoService.listarContratosPorUsuario(iduserc);
        return new WrapperResponse<>(true, "success", contratos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/servicio/{id}")
    public ResponseEntity<WrapperResponse<List<Contrato>>> listarContratosPorUsuarioServicio(@PathVariable("id") Integer idusuario){
        List<Contrato> contratos = contratoService.listarContratosPorUsuarioServicio(idusuario);
        return new WrapperResponse<>(true, "success", contratos).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<Contrato>> obtenerContratoPorId(@PathVariable("id") Long id){
        Contrato contrato = contratoService.obtenerContratoPorId(id);
        return new WrapperResponse<>(true, "success", contrato).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminarContrato(@PathVariable Long id){
        contratoService.eliminarContrato(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.NO_CONTENT);
    }

}
