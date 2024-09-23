package org.ide.proyectospring1.proyecto.controller;

import org.ide.proyectospring1.proyecto.domain.Proyecto;
import org.ide.proyectospring1.proyecto.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    private final ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    // Crear un nuevo proyecto
    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto nuevoProyecto = proyectoService.guardarProyecto(proyecto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProyecto);
    }

    // Obtener un proyecto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(proyecto);
    }

    // Obtener todos los proyectos
    @GetMapping
    public ResponseEntity<List<Proyecto>> obtenerTodosLosProyectos() {
        List<Proyecto> proyectos = proyectoService.obtenerTodosLosProyectos();
        return ResponseEntity.ok(proyectos);
    }

    // Actualizar un proyecto existente
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto detallesProyecto) {
        try {
            Proyecto proyectoActualizado = proyectoService.actualizarProyecto(id, detallesProyecto);
            return ResponseEntity.ok(proyectoActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Eliminar un proyecto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
