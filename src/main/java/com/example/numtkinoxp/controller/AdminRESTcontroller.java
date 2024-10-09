package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Movie;
import com.example.numtkinoxp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminRESTcontroller {


    @Autowired
    MovieRepository movieRepository;



    @PostMapping("/createmovie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie) {
        System.out.println("Received movie: " + newMovie);
        Movie savedMovie = movieRepository.save(newMovie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }


}
