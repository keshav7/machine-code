package com.base.parkinglot.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SpotHistory {

  ParkingSpot spot;
  Vehicle vehicle;
  Long startTime;
  Long endTime;
  SpotHistoryType type;

}
