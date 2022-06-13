package com.example.AppMovie.controller;

import com.example.AppMovie.model.Pelicula;
import com.example.AppMovie.model.Personaje;
import com.example.AppMovie.service.PeliculaService;
import com.example.AppMovie.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;

@RestController
@RequestMapping("/api/personaje")
@CrossOrigin(origins = "http://localhost:8080")
public class PersonajeController {

    @Autowired
    private PersonajeService servicePersonaje;
    @Autowired
    private PeliculaService servicePelicula;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Personaje>> list() {
        List<Personaje> salida = null;
        try {
            salida = servicePersonaje.list();
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.ok(salida);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Personaje> save(@RequestBody Personaje personaje) {
        Pelicula peliculaOptional = servicePelicula.getById(personaje.getPelicula().getIdPelicula());
        try {
            if (peliculaOptional == null) {
                return ResponseEntity.unprocessableEntity().build();
            }
            personaje.setPelicula(peliculaOptional);
            personaje.setIdPersonaje(0);
            Personaje obj = servicePersonaje.save(personaje);
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idPersonaje}")
    @ResponseBody
    public ResponseEntity<Personaje> edit(@PathVariable int idPersonaje, @RequestBody Personaje personaje) {
        Pelicula peliculaOptional = servicePelicula.getById(personaje.getPelicula().getIdPelicula());
        if (peliculaOptional == null) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Personaje personajeOptional = servicePersonaje.getById(idPersonaje);
        if (personajeOptional == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        personaje.setPelicula(peliculaOptional);
        personaje.setIdPersonaje(personajeOptional.getIdPersonaje());
        servicePersonaje.save(personaje);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idPersonaje}")
    public void delete(@PathVariable int idPersonaje) {
        servicePersonaje.delete(idPersonaje);
    }
}
