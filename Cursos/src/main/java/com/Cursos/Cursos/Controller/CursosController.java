package com.Cursos.Cursos.Controller;

import com.Cursos.Cursos.Model.Cursos;
import com.Cursos.Cursos.Service.CursosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cursos")
public class CursosController {

    private final CursosService cursosService;

    public CursosController(CursosService cursosService) {
        this.cursosService = cursosService;
    }

    @GetMapping("/todos")
    public List<Cursos> allCursos(){
        return cursosService.allCursos();
    }
    @GetMapping("/{cod}")
    Optional<Cursos> cursoCod(@PathVariable("cod") String codCurso){
        return cursosService.cursoCod(codCurso);
    }
    @PostMapping
    public List<Cursos> añadirCurso(@RequestBody Cursos cursos){
        cursosService.añadirCurso(cursos);
        return cursosService.allCursos();
    }

    @Operation(summary = "Crear nuevo curso", description = "Crear un nuevo curso con sus atributos ")
    @PostMapping("/nuevo")

    public void nuevoCurso(@RequestBody Cursos cursos){
        cursosService.añadirCurso(cursos);
    }


    @PutMapping
    public void actualizarCurso(@RequestBody Cursos cursos){
        cursosService.actualizarCurso(cursos);
    }
    @Operation(summary = "Actualizar curso por Id", description = "Actualizar un determinado curso, que seleccionaremos a traves de su Id")
    @PutMapping("/{cod}")
    public List<Cursos> actualizarCursoId(@Parameter(description = "Variable introducida por el usuario para seleccionar un curso por su ID") @PathVariable("cod") String codCurso , @RequestParam("duracion") int duracion){
        cursosService.actualizarDuracion(codCurso ,duracion);
        return cursosService.allCursos();
    }




    @DeleteMapping("/id/{cod}")
    public List<Cursos> borrarCurso(@PathVariable("cod") String codCurso){

        cursosService.borrarCurso(codCurso);
        return cursosService.allCursos();
    }


    @DeleteMapping("/{cod}")
    public void borrar(@PathVariable("cod") String codCurso){

        cursosService.borrarCurso(codCurso);

    }
}
