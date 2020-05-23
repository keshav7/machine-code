package com.bms.service.impl;

import com.bms.model.Show;
import com.bms.pojo.request.AddShowRequest;
import com.bms.service.api.ShowService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ShowServiceImpl implements ShowService {


  Map<String, Show> showMap = new HashMap<>();
  Map<String, List<String>> cinemaShowMap = new HashMap<>();


  @Override
  public Show addShow(AddShowRequest request) {

    Show show = Show.builder()
        .id(UUID.randomUUID().toString().substring(3, 7))
        .cinemaId(request.getCinemaId())
        .movieId(request.getMovieId())
        .startTime(request.getStartTime())
        .durationInMins(request.getDurationInMinutes())
        .build();

    showMap.put(request.getName(), show);
    
    List<String> shows = cinemaShowMap.get(request.getCinemaId());

    if (shows == null || shows.isEmpty()) {
      shows = new ArrayList<>();
    }

    shows.add(show.getId());

    return show;


  }

  @Override
  public List<Show> getShowsByCinemaId(String cinemaId) {
    List<Show> results = new ArrayList<>();
    List<String> shows = cinemaShowMap.get(cinemaId);

    if (shows != null && !shows.isEmpty()) {
      for (String showId : shows) {
        results.add(showMap.get(showId));
      }
    }

    return results;
  }

  @Override
  public Show getShow(String showId) {
    return showMap.get(showId);
  }
}
