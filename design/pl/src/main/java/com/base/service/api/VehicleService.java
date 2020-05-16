package com.base.service.api;

import com.base.model.Vehicle;
import com.base.model.VehicleType;

public interface VehicleService {

  Vehicle addVehicle(String regNum, VehicleType type);

  Vehicle getvehicle(String regNum);
}
