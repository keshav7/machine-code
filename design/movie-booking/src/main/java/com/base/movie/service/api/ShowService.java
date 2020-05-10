package com.base.movie.service.api;

import com.base.movie.model.Show;

import java.util.List;

public interface ShowService {

  Show addShow(String cinemaId, String movieId);

  Show getShow(String showId);

  List<Show> searchShows(String cinemaId, String movieId);
}
