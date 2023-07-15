package com.example.backendserviempleo.validators;

import com.example.backendserviempleo.exceptions.IncorrectResourceRequestException;
import com.example.backendserviempleo.models.Servicio;

public class ServicioValidator {

    public static void validate(Servicio servicio){

        if(servicio.getTitulo() == null || servicio.getTitulo().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El titulo es requerido");
        }

        if(servicio.getTitulo().length() < 3) {
            throw new IncorrectResourceRequestException("El titulo debe ser mayor a 3 caracteres");
        }

        if(servicio.getCosto() == null || servicio.getCosto().toString().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El costo es requerido");
        }

        if(servicio.getCosto() < 0) {
            throw new IncorrectResourceRequestException("El costo debe ser un valor mayor a 0");
        }

        if(servicio.getDescripcion() == null || servicio.getDescripcion().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La descripción es requerida");
        }

        if(servicio.getDescripcion().length() < 3) {
            throw new IncorrectResourceRequestException("La descripción debe ser mayor a 3 caracteres");
        }

    }

}
