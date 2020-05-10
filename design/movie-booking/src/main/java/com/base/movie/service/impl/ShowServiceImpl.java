package com.base.movie.service.impl;

import com.base.movie.model.Show;
import com.base.movie.service.api.ShowService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShowServiceImpl implements ShowService {


  List<Show> shows = new ArrayList<>();

  @Override
  public Show addShow(String cinemaId, String movieId) {
    Show show = Show.builder().cinemaId(cinemaId).movieId(movieId).id(UUID.randomUUID().toString()).build();
    shows.add(show);
    System.out.println("Added show" + show);
    return show;
  }

  @Override
  public Show getShow(String showId) {
    for (Show show : shows) {
      if (show.getId().equals(showId)) {
        return show;
      }
    }
    return null;
  }

  @Override
  public List<Show> searchShows(String cinemaId, String movieId) {
    List<Show> resultShows = new ArrayList<>();
    for (Show show : shows) {
      if (show.getCinemaId().equals(cinemaId) && show.getMovieId().equals(movieId)) {
        resultShows.add(show);
      }
    }
    return resultShows;
  }
}