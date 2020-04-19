package com.base.parkinglot.service.impl;

import com.base.parkinglot.data.Floor;
import com.base.parkinglot.data.ParkingSpot;
import com.base.parkinglot.data.Vehicle;
import com.base.parkinglot.data.VehicleType;
import com.base.parkinglot.service.api.FloorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FloorServiceImpl implements FloorService {


  private List<Floor> floors;

  @Override
  public void initialise(int numFloors) {

    floors = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
      // cab make it multi floor also
      Floor floor = new Floor();
      floor.setLabel("F" + (i + 1));
      ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
      concurrentHashMap.put(VehicleType.TRUCK, getParkingSpotQueue(floor, 10));
      concurrentHashMap.put(VehicleType.CAR, getParkingSpotQueue(floor, 20));
      concurrentHashMap.put(VehicleType.TWOWHEELER, getParkingSpotQueue(floor, 40));
      floor.setAvailableSpots(concurrentHashMap);
      floor.setOccupiedSpotsMap(new ConcurrentHashMap<>());

      floors.add(floor);
    }

  }


  private PriorityQueue<ParkingSpot> getParkingSpotQueue(Floor floor, int num) {

    PriorityQueue priorityQueue = new PriorityQueue(new ParkingSpotComparator());
    for (int i = 0 ; i < num; i++) {
      priorityQueue.add(new ParkingSpot(false, null, getLabel(floor , i)));
    }
    return priorityQueue;

  }


  private String getLabel(Floor floor, int num) {

    return floor.getLabel() + ", " + num;
  }


  @Override
  public Boolean isSpotAvailable(Vehicle vehicle) {

    VehicleType type = vehicle.getType();

    for (Floor floor : floors)  {
      ConcurrentHashMap<VehicleType, PriorityQueue<ParkingSpot>> availableSpotsMap = floor.getAvailableSpots();
      if (availableSpotsMap.get(type).size() > 0) {
        return true;
      }
    }

    return false;
  }

  @Override
  public ParkingSpot assignParkingSpot(Vehicle vehicle) {

    VehicleType type = vehicle.getType();

    for (Floor floor : floors)  {
      ConcurrentHashMap<VehicleType, PriorityQueue<ParkingSpot>> availableSpotsMap = floor.getAvailableSpots();
      if (availableSpotsMap.get(type).size() > 0) {

        ParkingSpot spot = availableSpotsMap.get(type).poll();
        spot.setIsOccupied(true);
        spot.setVehicle(vehicle);
        floor.getOccupiedSpotsMap().put(vehicle.getRegNumber(), spot);
        return spot;
      }
    }


    return null;
  }



  @Override
  public ParkingSpot releaseSpot(Vehicle vehicle) {

    for (Floor floor : floors) {
      if (floor.getOccupiedSpotsMap().containsKey(vehicle.getRegNumber())) {
        ParkingSpot spot = floor.getOccupiedSpotsMap().get(vehicle.getRegNumber());

        spot.setIsOccupied(false);
        spot.setVehicle(null);
        floor.getAvailableSpots().get(vehicle.getType()).add(spot);
        return spot;
      }
    }

    return null;  // TODO impl
  }


  private class ParkingSpotComparator implements Comparator<ParkingSpot> {


    @Override
    public int compare(ParkingSpot s1, ParkingSpot s2) {
      return s1.getLabel().compareTo(s2.getLabel());
    }
  }



}
