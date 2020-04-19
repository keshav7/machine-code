package com.base.parkinglot.service.impl;

import com.base.parkinglot.data.ParkingSpot;
import com.base.parkinglot.data.SpotHistory;
import com.base.parkinglot.data.SpotHistoryType;
import com.base.parkinglot.data.Vehicle;
import com.base.parkinglot.data.VehicleType;
import com.base.parkinglot.service.api.FloorService;
import com.base.parkinglot.service.api.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@Service
public class ParkingLotImpl implements ParkingLotService {

  @Autowired
  FloorService floorService;

  private List<SpotHistory> spotHistoryList;

  @PostConstruct
  public void init() {
    System.out.println("this is parkinglot");
    spotHistoryList = new ArrayList<>();
    floorService.initialise(3);

    Vehicle bike = new Vehicle("A", VehicleType.TWOWHEELER);
    Vehicle car = new Vehicle("A", VehicleType.CAR);
    Vehicle truck = new Vehicle("A", VehicleType.TRUCK);


    assignParking(bike);
    assignParking(car);
    assignParking(truck);


    releaseParking(bike);
    releaseParking(car);

    printParkingHistory();





  }

  @Override
  public Boolean isParkingAvailable(Vehicle vehicle) {
    return null;  // TODO impl
  }

  @Override
  public ParkingSpot assignParking(Vehicle vehicle) {

    ParkingSpot parkingSpot = floorService.assignParkingSpot(vehicle);
    spotHistoryList.add(new SpotHistory(parkingSpot, vehicle, System.currentTimeMillis(), null, SpotHistoryType.ADDED));
    return parkingSpot;
  }

  @Override
  public ParkingSpot releaseParking(Vehicle vehicle) {
    ParkingSpot parkingSpot = floorService.releaseSpot(vehicle);
    spotHistoryList.add(new SpotHistory(parkingSpot, vehicle, null, System.currentTimeMillis(), SpotHistoryType.RELEASED));
    return parkingSpot;
  }

  @Override
  public void printParkingHistory() {
    for (SpotHistory spotHistory : spotHistoryList) {
      System.out.println(spotHistory.toString());
    }
  }
}
