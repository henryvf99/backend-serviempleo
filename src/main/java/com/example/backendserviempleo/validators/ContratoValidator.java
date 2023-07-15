package com.example.backendserviempleo.validators;

import com.example.backendserviempleo.exceptions.IncorrectResourceRequestException;
import com.example.backendserviempleo.models.Contrato;
import com.example.backendserviempleo.models.Servicio;

public class ContratoValidator {

    public static void validate(Contrato contrato){

        if(contrato.getNombre() == null || contrato.getNombre().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerido");
        }

        if(contrato.getNombre().length() < 3) {
            throw new IncorrectResourceRequestException("El nombre debe ser mayor a 3 caracteres");
        }

        if(contrato.getApellido() == null || contrato.getApellido().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El apellido es requerido");
        }

        if(contrato.getApellido().length() < 3) {
            throw new IncorrectResourceRequestException("El apellido debe ser mayor a 3 caracteres");
        }

        if(contrato.getTelefono() == null || contrato.getTelefono().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El telefono es requerido");
        }

        if(contrato.getTelefono().length() < 1 && contrato.getTelefono().length() > 9) {
            throw new IncorrectResourceRequestException("El telefono debe tener 9 caracteres");
        }

        if(contrato.getDireccion() == null || contrato.getDireccion().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La direccion es requerida");
        }

        if(contrato.getDireccion().length() < 3) {
            throw new IncorrectResourceRequestException("La direccion debe ser mayor a 3 caracteres");
        }

        if(contrato.getMensaje() == null || contrato.getMensaje().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El mensaje es requerido");
        }

        if(contrato.getMensaje().length() < 3) {
            throw new IncorrectResourceRequestException("El mensaje debe ser mayor a 3 caracteres");
        }

    }

}
