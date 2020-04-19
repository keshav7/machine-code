package com.base.parkinglot.service.api;

import com.base.parkinglot.data.ParkingSpot;
import com.base.parkinglot.data.Vehicle;

public interface ParkingLotService {

  Boolean isParkingAvailable(Vehicle vehicle);
  ParkingSpot assignParking(Vehicle vehicle);
  ParkingSpot releaseParking(Vehicle vehicle);
  void printParkingHistory();

}
