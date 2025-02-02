package com.Cursos.Cursos.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.naming.Context;
import javax.swing.text.AbstractDocument;

@Entity
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotBlank(message = "el nombre es obligatorio")
private String name;
@NotBlank(message = "La contraseña es obligatoria")
private String password;
@Enumerated(EnumType.STRING)
@Column(nullable = false)
private Role role;


    public Usuario(Long id, String name, String password, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public Usuario() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
