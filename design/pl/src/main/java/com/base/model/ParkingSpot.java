package com.base.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpot {

  String id;
  String name;
  SpotType type;
  Boolean occupied;

  Boolean isElectric;


}
