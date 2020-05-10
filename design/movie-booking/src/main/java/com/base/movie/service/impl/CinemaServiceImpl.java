package com.base.movie.service.impl;

import com.base.movie.model.Cinema;
import com.base.movie.service.api.CinemaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CinemaServiceImpl implements CinemaService {

  List<Cinema> cinemaList = new ArrayList<>();

  @Override
  public Cinema addCinema(String name) {
    Cinema cinema = Cinema.builder().id(UUID.randomUUID().toString()).name(name).build();
    cinemaList.add(cinema);
    System.out.println("Added cinema" + cinema);
    return cinema;
  }
}
