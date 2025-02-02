package com.Cursos.Cursos.Controller;

import com.Cursos.Cursos.Model.Usuario;
import com.Cursos.Cursos.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioService usuarioService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/all")
    public List<Usuario>allUser(){

        return usuarioService.allUser();

    }



    @PostMapping("/new")
    public ResponseEntity<String> newUsuario(@Valid @RequestBody Usuario usuario){

        if (usuarioService.existsByName(usuario.getName())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este nombre de  usuario ya existe");
        }
        usuarioService.newUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");

    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){

        usuarioService.delete(id);
    }

}
