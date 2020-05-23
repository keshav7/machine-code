package com.bms.controller;


import com.bms.model.Movie;
import com.bms.pojo.request.AddMovieRequest;
import com.bms.pojo.request.SearchMovieRequest;
import com.bms.service.api.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {


  @Autowired
  MovieService movieService;


  @PostMapping("/add")
  Movie addMovie(@RequestBody AddMovieRequest request) {

    return movieService.addMovie(request);
  }

  @PostMapping("/search")
  List<Movie> searchMovies(@RequestBody SearchMovieRequest request) {
    return movieService.searchMovies(request);
    
  }

}
