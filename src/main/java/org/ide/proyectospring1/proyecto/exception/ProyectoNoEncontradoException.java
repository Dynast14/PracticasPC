package org.ide.proyectospring1.proyecto.exception;

public class ProyectoNoEncontradoException extends RuntimeException {
    public ProyectoNoEncontradoException(Long id) {
        super("No se pudo encontrar el proyecto con el ID "+ id);
    }
}
