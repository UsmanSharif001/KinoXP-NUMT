package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Screening;
import com.example.numtkinoxp.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScreeningRESTcontroller {


    @Autowired
    ScreeningRepository screeningRepository;

    @GetMapping("/screenings")
    public List<Screening> getAllScreenings(){
        return screeningRepository.findAll();
    }

//    @GetMapping("/screening/{movieID}")
//    public List<Screening> getScreening(@PathVariable int movieID){
//       return screeningRepository.findScreeningByMovieID(movieID);
//    }
    
}
