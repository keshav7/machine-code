package com.base.parkinglot.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSpot {

  Boolean isOccupied;
  Vehicle vehicle;
  String label;

}
