package com.Cursos.Cursos.Service;

import com.Cursos.Cursos.Model.Role;
import com.Cursos.Cursos.Model.Usuario;
import com.Cursos.Cursos.Repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IServiceUsuario{

    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;


    }

    @Override
    public void newUsuario(Usuario usuario) {

        String encoder = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encoder);


        usuarioRepository.save(usuario);

    }



    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);

    }

    @Override
    public List<Usuario> allUser() {
        return usuarioRepository.findAll();
    }

    public boolean existsByName(String nombre) {
        return usuarioRepository.findByName(nombre).isPresent();
    }

  /* crear siempre usuario admin para que no se boore de base de datos

   @PostConstruct
    public void ensureAdminExists() {
        Usuario adminUser = usuarioRepository.findByName("admin")
                .orElseGet(() -> {
                    Usuario newAdmin = new Usuario();
                    newAdmin.setName("admin");
                    newAdmin.setPasswprd(passwordEncoder.encode("admin"));
                    newAdmin.setRole(Role.ADMIN);
                    return usuarioRepository.save(newAdmin);
                });

        // Asegurarte de que el rol sea siempre ADMIN
        if (!adminUser.getRole().equals(Role.ADMIN)) {
            adminUser.setRole(Role.ADMIN);
            usuarioRepository.save(adminUser);
        }
    }*/

}
