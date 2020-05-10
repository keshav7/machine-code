package com.base.movie.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Booking {

  String userId;
  String showId;
  String seatId;
}
