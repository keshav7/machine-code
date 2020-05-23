package com.bms.service.api;

import com.bms.model.CinemaSeat;

import java.util.List;

public interface CinemaSeatService {
  CinemaSeat addCinemaSeat(String cinemaId, String name);

  List<CinemaSeat> getCinemaSeats(String cinemaId);
}
