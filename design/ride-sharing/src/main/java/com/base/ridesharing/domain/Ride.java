package com.base.ridesharing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ride {

  String userId;
  String startLocation;
  String endLocation;
  Double duration;
  Long startTime;
}
