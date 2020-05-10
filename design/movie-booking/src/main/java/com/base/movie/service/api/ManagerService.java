package com.base.movie.service.api;

import com.base.movie.model.Cinema;
import com.base.movie.model.CinemaSeat;
import com.base.movie.model.Movie;
import com.base.movie.model.Show;

import java.util.List;

public interface ManagerService {

  void initialise();

  Movie addMovie(String name);

  Cinema addCinema(String name);

  CinemaSeat addCinemaSeats(Cinema cinema);

  Show addShow(Cinema cinema, Movie movie);

  void bookSeat(String user, String showId);

  List<CinemaSeat> getAvailaibleSeats(String showId);


}
