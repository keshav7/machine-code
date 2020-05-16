package com.base.service.impl;

import com.base.model.Vehicle;
import com.base.model.VehicleType;
import com.base.service.api.VehicleService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VehicleServiceImpl implements VehicleService {


  Map<String, Vehicle> vehicles = new HashMap<>();



  @Override
  public Vehicle addVehicle(String regNum, VehicleType type) {
    Vehicle vehicle = Vehicle.builder().regNum(regNum).type(type).build();
    vehicles.put(vehicle.getRegNum(), vehicle);
    return vehicle;
  }

  @Override
  public Vehicle getvehicle(String regNum) {
    return vehicles.get(regNum);
  }
}
