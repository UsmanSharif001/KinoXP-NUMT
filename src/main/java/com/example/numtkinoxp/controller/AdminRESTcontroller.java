package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Movie;
import com.example.numtkinoxp.model.Screening;
import com.example.numtkinoxp.repository.MovieRepository;
import com.example.numtkinoxp.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminRESTcontroller {


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ScreeningRepository screeningRepository;

    @GetMapping("/screenings")
    public ResponseEntity<List<Screening>> getAllScreenings() {
        List<Screening> screenings = screeningRepository.findAll();
        return new ResponseEntity<>(screenings, HttpStatus.OK);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieRepository.findAllByIsActiveTrue();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping("/createmovie")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie newMovie) {
        System.out.println("Received movie: " + newMovie);
        if (newMovie.getScrennings() != null) {
            newMovie.getScrennings().forEach(screening -> {
                System.out.println("Associated screening: " + screening);
            });
        }
        Movie savedMovie = movieRepository.save(newMovie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }


    @GetMapping("/movie/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        return movie.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/movie/{movieId}")
    public ResponseEntity<Movie>updateMovie(@PathVariable Integer movieId, @RequestBody Movie movieDetails) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setTitle(movieDetails.getTitle());
            movie.setDescription(movieDetails.getDescription());
            movie.setHrefImage(movieDetails.getHrefImage());
            movie.setRunningTime(movieDetails.getRunningTime());
            movie.setRecommendedAge(movieDetails.getRecommendedAge());
            movie.setIs3D(movieDetails.isIs3D());
            movie.setActive(movieDetails.isActive());
            movieRepository.save(movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }
    @DeleteMapping("/movie/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable Integer movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            Movie movieToDelete = movie.get();
            movieToDelete.setActive(false); // Her bliver den til inaktiv når man sletter, arkiveret (til fremtidig implementering)
            movieRepository.save(movieToDelete);
            return ResponseEntity.ok("Movie marked as inactive.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found.");
        }
    }

}
