package com.Cursos.Cursos.Repository;

import com.Cursos.Cursos.Model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, String> {
}
