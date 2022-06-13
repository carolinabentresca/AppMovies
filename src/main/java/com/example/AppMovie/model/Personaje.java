package com.example.AppMovie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "personajes")
public class Personaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idPersonaje;
    @Column
    private String nombre;
    @Column
    private String historia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pelicula")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Pelicula pelicula;

    public Personaje() {
    }

    public Personaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public Personaje(int idPersonaje, String nombre, String historia, Pelicula pelicula) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
        this.historia = historia;
        this.pelicula = pelicula;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

}
