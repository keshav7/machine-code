package com.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLot {


  String id;
  String name;
  Map<SlotStatus, List<ParkingSpot>> twoWheeler = new HashMap<>();
  Map<SlotStatus, List<ParkingSpot>> fourWheeler = new HashMap<>();


}
