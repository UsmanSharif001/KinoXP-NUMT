package com.example.numtkinoxp.repository;

import com.example.numtkinoxp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByIsActiveTrue();

}
