package org.ide.proyectospring1.proyecto.service;

import org.ide.proyectospring1.proyecto.domain.Proyecto;
import org.ide.proyectospring1.proyecto.exception.ProyectoNoEncontradoException;
import org.ide.proyectospring1.proyecto.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    // Crear o guardar un proyecto
    public Proyecto guardarProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    // Obtener un proyecto por su ID
    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id)
                .orElseThrow(() -> new ProyectoNoEncontradoException(id));
    }

    // Obtener todos los proyectos
    public List<Proyecto> obtenerTodosLosProyectos() {
        return proyectoRepository.findAll();
    }

    // Actualizar un proyecto
    public Proyecto actualizarProyecto(Long id, Proyecto detallesProyecto) {
        return proyectoRepository.findById(id)
                .map(proyectoExistente -> {
                    proyectoExistente.setCodigo(detallesProyecto.getCodigo());
                    proyectoExistente.setNombre(detallesProyecto.getNombre());
                    proyectoExistente.setDescripcion(detallesProyecto.getDescripcion());
                    proyectoExistente.setFechaInicio(detallesProyecto.getFechaInicio());
                    proyectoExistente.setFechaFin(detallesProyecto.getFechaFin());
                    proyectoExistente.setLiderId(detallesProyecto.getLiderId());
                    return proyectoRepository.save(proyectoExistente);
                })
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado con ID: " + id));
    }

    // Eliminar un proyecto
    public void eliminarProyecto(Long id) {
        if (!proyectoRepository.existsById(id)) {
            throw new ProyectoNoEncontradoException(id);
        }
        proyectoRepository.deleteById(id);
    }
}
