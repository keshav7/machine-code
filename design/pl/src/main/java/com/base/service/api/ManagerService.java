package com.base.service.api;

import com.base.model.VehicleSpot;
import com.base.model.VehicleType;

import java.util.List;

public interface ManagerService {

  VehicleSpot assignSpot(String regNum, VehicleType type);
  Double exitVehicle(String regNum, String parkingLotId);

  List<VehicleSpot> getVehicleHistory(String regNum);

}
