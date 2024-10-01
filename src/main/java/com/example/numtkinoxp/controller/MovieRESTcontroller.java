package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Movie;
import com.example.numtkinoxp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieRESTcontroller {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

}
