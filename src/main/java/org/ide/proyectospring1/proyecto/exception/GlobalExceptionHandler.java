package org.ide.proyectospring1.proyecto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(name = "proyectoGlobalExceptionHandler")
public class GlobalExceptionHandler{

    @ExceptionHandler(ProyectoNoEncontradoException.class)
    public ResponseEntity<String> manejarProyectoNoEncontrado(ProyectoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> manejarErroresGenerales(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error inesperado.");
    }
}