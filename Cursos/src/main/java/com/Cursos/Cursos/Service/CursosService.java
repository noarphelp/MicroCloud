package com.Cursos.Cursos.Service;

import com.Cursos.Cursos.Model.Cursos;
import com.Cursos.Cursos.Model.Role;
import com.Cursos.Cursos.Model.Usuario;
import com.Cursos.Cursos.Repository.CursosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursosService implements IServiceCursos{

    private final CursosRepository cursosRepository;

    public CursosService(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;

    }

    @Override
    public List<Cursos> allCursos() {
        return cursosRepository.findAll();
    }

    @Override
    public Optional<Cursos> cursoCod(String codCurso) {
        return Optional.ofNullable(cursosRepository.findById(codCurso).orElse(null));
    }

    @Override
    public void añadirCurso(Cursos cursos) {
        cursosRepository.save(cursos);
    }

    @Override
    public void actualizarCurso(Cursos cursos) {
        cursosRepository.save(cursos);

    }

    public void actualizarDuracion(String codCurso , int Duracion){

        Optional<Cursos> cursoOpt=cursosRepository.findById(codCurso);

        if (cursoOpt.isPresent()) {

            Cursos curso = cursoOpt.get();
            curso.setDuracion(Duracion); // Actualizar la duración
            cursosRepository.save(curso);    // Guardar el cambio en la base de datos
        }
    }

    @Override
    public void borrarCurso(String codCurso) {
        cursosRepository.deleteById(codCurso);

    }
}
