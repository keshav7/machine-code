package com.base.movie.service.api;

import com.base.movie.model.CinemaSeat;
import java.util.List;

public interface CinemaSeatsService {


  CinemaSeat addSeat(String cinemaId);
  List<CinemaSeat> getSeats(String cinemaId);

}
