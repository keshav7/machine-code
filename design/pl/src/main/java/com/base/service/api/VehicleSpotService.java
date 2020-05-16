package com.base.service.api;

import com.base.model.VehicleSpot;

import java.util.List;

public interface VehicleSpotService {

  VehicleSpot addVehicleSpot(String regNum, String parkingLotId, String spotId, Long entryTime);

  void updateVehicleSpot(String id, Double amount, Long existTime);

  List<VehicleSpot> getVehicleSPots(String regNum);

}
