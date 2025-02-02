package com.Cursos.Cursos.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
@Entity
public class Cursos {
    @Id

    private String codCurso;
    @Column(unique = true, nullable = false)
    private String nombre;
    private Integer duracion;
    private double precio;

    public Cursos(String codCurso, String nombre, Integer duracion, double precio) {
        this.codCurso = codCurso;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    public Cursos() {
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public Cursos setDuracion(Integer duracion) {
        this.duracion = duracion;
        return null;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
