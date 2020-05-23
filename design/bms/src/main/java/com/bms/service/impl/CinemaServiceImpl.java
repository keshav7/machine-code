package com.bms.service.impl;

import com.bms.model.Cinema;
import com.bms.service.api.CinemaService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CinemaServiceImpl implements CinemaService {

  Map<String, Cinema> cinemaMap = new HashMap<>();
  Map<String, List<String>> cityCinemaMap = new HashMap<>();

  @Override
  public Cinema addCinema(String name, String cityName) {
    Cinema cinema = Cinema.builder()
        .id(UUID.randomUUID().toString().substring(0, 3))
        .name(name)
        .city(cityName)
        .build();

    cinemaMap.put(cinema.getId(), cinema);
    
    List<String> cinemaList = cityCinemaMap.get(cityName);
    if (cinemaList == null || cinemaList.isEmpty()) {
      cinemaList = new ArrayList<>();
      cinemaList.add(cinema.getId());
    } else {
      cinemaList.add(cinema.getId());
    }
    cityCinemaMap.put(cityName, cinemaList);
    return cinema;
  }

  




}
