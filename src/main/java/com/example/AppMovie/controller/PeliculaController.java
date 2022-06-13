package com.example.AppMovie.controller;

import com.example.AppMovie.model.Pelicula;
import com.example.AppMovie.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api/pelicula")
@CrossOrigin(origins = "http://localhost:8080")
public class PeliculaController {

    @Autowired
    private PeliculaService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Pelicula>> list() {
        List<Pelicula> salida = null;
        try {
            salida = service.list();
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.ok(salida);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> save(@RequestBody Pelicula pelicula) {
        Map<String, Object> salida = new HashMap<>();
        try {
            pelicula.setIdPelicula(0);
            Pelicula obj = service.save(pelicula);
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/{idPelicula}")
    @ResponseBody
    public ResponseEntity<Pelicula> edit(@PathVariable int idPelicula, @RequestBody Pelicula pelicula) {
        Pelicula peliculaOptional = service.getById(idPelicula);
        try {
            if (peliculaOptional == null) {
                return ResponseEntity.unprocessableEntity().build();
            }
            pelicula.setIdPelicula(peliculaOptional.getIdPelicula());
            service.save(pelicula);
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{idPelicula}")
    public void delete(@PathVariable int idPelicula) {
        service.delete(idPelicula);
    }

}
