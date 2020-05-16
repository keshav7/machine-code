package com.base.service.impl;

import com.base.model.VehicleType;
import com.base.service.api.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Booter {

  @Autowired
  ManagerService managerService;

  public void booter() {

    managerService.assignSpot("ABC", VehicleType.TWO_WHEELER);
    managerService.assignSpot("DEF", VehicleType.FOUR_WHEELER);
    managerService.assignSpot("MNO", VehicleType.TWO_WHEELER);
    managerService.assignSpot("XYZ", VehicleType.FOUR_WHEELER);


    managerService.exitVehicle("ABC", "1");

    managerService.getVehicleHistory("ABC");

  }



}
