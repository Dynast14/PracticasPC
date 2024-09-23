package org.ide.proyectospring1.empleado.controller;

import org.ide.proyectospring1.empleado.domain.Empleado;
import org.ide.proyectospring1.empleado.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<Empleado> registrarEmpleado(@RequestBody Empleado empleado) {
        if (empleado.getNombre() == null || empleado.getApellido() == null || empleado.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }
        Empleado nuevoEmpleado = empleadoService.registrarEmpleado(empleado);
        return ResponseEntity.ok().body(nuevoEmpleado);
    }
    @GetMapping
    public List<Empleado> listarEmpleados() {
        return empleadoService.obtenerTodos();
    }
}
