package com.bms.service.impl;

import com.bms.model.CinemaSeat;
import com.bms.service.api.CinemaSeatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CinemaSeatServiceImpl implements CinemaSeatService {

  Map<String, List<CinemaSeat>> cinemaSeatMap = new HashMap<>();


  @Override
  public CinemaSeat addCinemaSeat(String cinemaId, String name) {

    CinemaSeat cinemaSeat = CinemaSeat.builder()
        .id(UUID.randomUUID().toString().substring(3, 7))
        .cinemaId(cinemaId)
        .name(name)
        .build();

    List<CinemaSeat> cinemaSeats = cinemaSeatMap.get(cinemaId);
    if (cinemaSeats == null || cinemaSeats.isEmpty()) {
      cinemaSeats = new ArrayList<>();
    }

    cinemaSeats.add(cinemaSeat);
    cinemaSeatMap.put(cinemaId, cinemaSeats);
    return cinemaSeat;
  }

  @Override
  public List<CinemaSeat> getCinemaSeats(String cinemaId) {
    return cinemaSeatMap.get(cinemaId);
  }
}
