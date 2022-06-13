package com.example.AppMovie.service;

import com.example.AppMovie.model.Pelicula;
import com.example.AppMovie.repository.PeliculaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository repository;

    //Método List
    public List<Pelicula> list() {
        return repository.findAll();
    }

    //Método Get By Id
    public Pelicula getById(int idPelicula) {
        return repository.findById(idPelicula).get();
    }

    //Método Save and Update
    public Pelicula save(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    //Método Delete
    public void delete(int idPelicula) {
        repository.deleteById(idPelicula);
    }

}
