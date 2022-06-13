package com.example.AppMovie.service;

import com.example.AppMovie.model.Personaje;
import com.example.AppMovie.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository repository;

    //Método List
    public List<Personaje> list() {
        return repository.findAll();
    }

    //Método Get By Id
    public Personaje getById(int idPersonaje) {
        return repository.findById(idPersonaje).get();
    }

    //Método Save and Update
    public Personaje save(Personaje personaje) {
        return repository.save(personaje);
    }

    //Método Delete
    public void delete(int idPersonaje) {
        repository.deleteById(idPersonaje);
    }
}
