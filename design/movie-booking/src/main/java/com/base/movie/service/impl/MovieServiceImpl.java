package com.base.movie.service.impl;

import com.base.movie.model.Movie;
import com.base.movie.service.api.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

  List<Movie> moviesList = new ArrayList<>();

  @Override
  public Movie addMovie(String name) {
    Movie movie = Movie.builder().name(name).id(UUID.randomUUID().toString()).build();
    moviesList.add(movie);
    System.out.println("Added movie" + movie);
    return movie;
  }
}
