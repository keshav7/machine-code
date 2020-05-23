package com.bms.service.impl;

import com.bms.model.Movie;
import com.bms.pojo.request.AddMovieRequest;
import com.bms.pojo.request.SearchMovieRequest;
import com.bms.service.api.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

  Map<String, Movie> movieMap = new HashMap<>();

  Map<String, List<String>> cityMovieMap = new HashMap<>();

  @Override
  public Movie addMovie(AddMovieRequest addMovieRequest) {

    Movie movie = Movie.builder()
        .id(UUID.randomUUID().toString().substring(0,3))
        .name(addMovieRequest.getName())
        .build();
    movieMap.put(movie.getId(), movie);
    if (cityMovieMap.containsKey(addMovieRequest.getCityId())) {
      List<String> movies = cityMovieMap.get(addMovieRequest.getCityId());
      movies.add(movie.getId());
      cityMovieMap.put(addMovieRequest.getCityId(), movies);
    } else {
      List<String> movies = new ArrayList<>();
      movies.add(movie.getId());
      cityMovieMap.put(addMovieRequest.getCityId(), movies);
    }
    movieMap.put(movie.getId(), movie);
    return movie;
  }

  @Override
  public List<Movie> searchMovies(SearchMovieRequest request) {
    List<Movie> results = new ArrayList<>();
    List<String> moviesInCity = cityMovieMap.get(request.getCity());
    if (moviesInCity == null || moviesInCity.isEmpty()) {
      return results;
    }
    for (String movieId : moviesInCity) {
      results.add(movieMap.get(movieId));
    }
    return results;

  }
}
