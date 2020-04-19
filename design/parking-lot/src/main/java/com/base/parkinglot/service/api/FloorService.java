package com.base.parkinglot.service.api;

import com.base.parkinglot.data.ParkingSpot;
import com.base.parkinglot.data.Vehicle;

public interface FloorService {

  void initialise(int numFloors);
  Boolean isSpotAvailable(Vehicle vehicle);
  ParkingSpot assignParkingSpot(Vehicle vehicle);
  ParkingSpot releaseSpot(Vehicle vehicle);

}
