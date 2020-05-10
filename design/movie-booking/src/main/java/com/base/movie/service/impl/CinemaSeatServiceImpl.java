package com.base.movie.service.impl;

import com.base.movie.model.CinemaSeat;
import com.base.movie.service.api.CinemaSeatsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CinemaSeatServiceImpl implements CinemaSeatsService {

  Map<String, List<CinemaSeat>> cinemaSeats = new HashMap<>();

  @Override
  public CinemaSeat addSeat(String cinemaId) {
    if (!cinemaSeats.containsKey(cinemaId)) {
      cinemaSeats.put(cinemaId, new ArrayList<>());
    }
    CinemaSeat cinemaSeat = CinemaSeat.builder().cinemaId(cinemaId).id(UUID.randomUUID().toString()).build();
    cinemaSeats.get(cinemaId).add(cinemaSeat);
    System.out.println("Added cinema seat" + cinemaSeat);
    return cinemaSeat;
  }

  @Override
  public List<CinemaSeat> getSeats(String cinemaId) {
    return cinemaSeats.get(cinemaId);
  }
}