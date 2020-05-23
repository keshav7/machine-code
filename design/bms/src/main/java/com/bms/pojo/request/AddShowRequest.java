package com.bms.pojo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddShowRequest {
  String cinemaId;
  String movieId;
  String name;
  Long startTime;
  Integer durationInMinutes;
  // can extend for type etc.
}
