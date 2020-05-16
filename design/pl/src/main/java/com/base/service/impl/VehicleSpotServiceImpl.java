package com.base.service.impl;

import com.base.model.VehicleSpot;
import com.base.service.api.VehicleSpotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleSpotServiceImpl implements VehicleSpotService {

  List<VehicleSpot> vehicleSpotList = new ArrayList<>();

  @Override
  public VehicleSpot addVehicleSpot(String regNum, String parkingLotId, String spotId, Long entryTime) {
    VehicleSpot vehicleSpot = VehicleSpot.builder()
        .spotId(UUID.randomUUID().toString().substring(1, 5))
        .vehicleNum(regNum)
        .parkingLotId(parkingLotId)
        .spotId(spotId)
        .entryTime(System.currentTimeMillis())
        .build();
    vehicleSpotList.add(vehicleSpot);
    return vehicleSpot;
  }

  @Override
  public void updateVehicleSpot(String id, Double amount, Long existTime) {

    for (VehicleSpot vehicleSpot : vehicleSpotList) {
      if (vehicleSpot.getSpotId().equals(id)) {
        vehicleSpot.setAmoutPaid(amount);
        vehicleSpot.setExitTime(System.currentTimeMillis());
      }
    }


  }

  @Override
  public List<VehicleSpot> getVehicleSPots(String regNum) {
    List<VehicleSpot> vehicleSpots = new ArrayList<>();

    for (VehicleSpot vehicleSpot : vehicleSpotList) {
      if (vehicleSpot.getVehicleNum().equals(regNum)) {
        vehicleSpots.add(vehicleSpot);
      }
    }
    return vehicleSpots;


  }
}
