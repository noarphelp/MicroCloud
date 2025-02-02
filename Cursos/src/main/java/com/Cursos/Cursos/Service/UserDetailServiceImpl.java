package com.Cursos.Cursos.Service;

import com.Cursos.Cursos.Model.Usuario;
import com.Cursos.Cursos.Repository.UsuarioRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    public UserDetailServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el nombre: "+ name));

        List<GrantedAuthority>authorities= new ArrayList<>();

        if("admin".equals(usuario.getName())){

            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        }

        System.out.println("Usuario: " + usuario.getName());
        System.out.println("Roles asignados: " + authorities);

        return  new org.springframework.security.core.userdetails.User(usuario.getName(), usuario.getPassword(), authorities);

    }
}
