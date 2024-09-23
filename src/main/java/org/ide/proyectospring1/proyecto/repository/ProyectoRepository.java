package org.ide.proyectospring1.proyecto.repository;

import org.ide.proyectospring1.proyecto.domain.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Long> {
}
