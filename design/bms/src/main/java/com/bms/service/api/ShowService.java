package com.bms.service.api;

import com.bms.model.Show;
import com.bms.pojo.request.AddShowRequest;

import java.util.List;

public interface ShowService {

  Show addShow(AddShowRequest request);

  Show getShow(String showId);

  List<Show> getShowsByCinemaId(String cinemaId);
  // can also additionally have generic search shows api
}
