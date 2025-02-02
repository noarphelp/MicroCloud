package com.Cursos.Cursos.Service;

import com.Cursos.Cursos.Model.Cursos;

import java.util.List;
import java.util.Optional;

public interface IServiceCursos {
    public List<Cursos>allCursos();
    Optional <Cursos> cursoCod(String codCurso);
    public void añadirCurso(Cursos cursos);
    public void actualizarCurso(Cursos cursos);
    public void borrarCurso(String codCurso);


}
