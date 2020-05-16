package com.base.service.api;

import com.base.model.ParkingLot;
import com.base.model.ParkingSpot;
import com.base.model.SpotType;

public interface ParkingLotService {



  ParkingLot addParkingLot(Integer twoWheelSlots, Integer fourWheelSlots);

  ParkingSpot getParkingSpot(String parkingLotId, SpotType spotType);

  void addVehicleSpotMap(String regNum, String spotId);

  String getSpotId(String regNum);


}
