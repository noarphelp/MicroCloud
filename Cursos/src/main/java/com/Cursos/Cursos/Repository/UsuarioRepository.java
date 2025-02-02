package com.Cursos.Cursos.Repository;

import com.Cursos.Cursos.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , Long> {

    Optional<Usuario> findByName(String name);



}
