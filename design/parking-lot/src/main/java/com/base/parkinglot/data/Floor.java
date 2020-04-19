package com.base.parkinglot.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Floor {

  private String label;
  private ConcurrentHashMap<VehicleType, PriorityQueue<ParkingSpot>> availableSpots;
  ConcurrentHashMap<String, ParkingSpot> occupiedSpotsMap;
}