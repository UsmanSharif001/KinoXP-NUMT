package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Movie;
import com.example.numtkinoxp.model.Screening;
import com.example.numtkinoxp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class MovieRESTcontroller {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/{id}/screenings")
    public Set<Screening> getScreeningsForMovie(@PathVariable int id){
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if(movieOptional.isPresent()){
            Movie movie = movieOptional.get();
            return movie.getScrennings();
        } else {
            return null;
        }
  }

     @GetMapping("/movies/{id}") //Fetcher en movie ud fra dens ID - hvis ikke fundet = null.
     public Movie getMovieById(@PathVariable int id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
            return movieOptional.orElse(null);
}

}
