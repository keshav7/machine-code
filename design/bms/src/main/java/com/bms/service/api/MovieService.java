package com.bms.service.api;

import com.bms.model.Movie;
import com.bms.pojo.request.AddMovieRequest;
import com.bms.pojo.request.SearchMovieRequest;

import java.util.List;

public interface MovieService {

  Movie addMovie(AddMovieRequest addMovieRequest);

  List<Movie> searchMovies(SearchMovieRequest request);

}
