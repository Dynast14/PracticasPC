package org.ide.proyectospring1.empleado.service;

import org.ide.proyectospring1.empleado.domain.Empleado;
import org.ide.proyectospring1.empleado.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    //Metodo para registrar un nuevo empleado
    public Empleado registrarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
    //Metodo para obtener todos los empleados
    public List<Empleado> obtenerTodos(){
        return empleadoRepository.findAll();
    }
}
