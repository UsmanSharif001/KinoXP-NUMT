package com.example.numtkinoxp.repository;

import com.example.numtkinoxp.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.numtkinoxp.model.Movie;

import java.util.List;

public interface ScreeningRepository  extends JpaRepository<Screening, Integer> {

//    List<Screening> findScreeningByMovieID(int movieID);


}
