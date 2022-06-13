package com.example.AppMovie.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idPelicula;
    @Column
    private String titulo;
    @Column
    private String genero;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    private List<Personaje> personajes = new ArrayList();

    public Pelicula() {
    }

    public Pelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Pelicula(int idPelicula, String titulo, String genero) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
        for (Personaje personaje : personajes) {
            personaje.setPelicula(this);
        }
    }

}
