package com.Cursos.Cursos.Service;

import com.Cursos.Cursos.Model.Usuario;

import java.util.List;

public interface IServiceUsuario {

    void newUsuario(Usuario usuario);
    void delete(long id);

    List<Usuario>allUser();
}
