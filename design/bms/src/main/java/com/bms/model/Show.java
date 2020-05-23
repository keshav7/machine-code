package com.bms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Show {

  String id;
  String cinemaId;
  String movieId;
  String name;
  Long startTime;
  Integer durationInMins;
}
