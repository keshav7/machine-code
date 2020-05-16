package com.base.service.impl;

import com.base.model.ParkingSpot;
import com.base.model.SpotType;
import com.base.model.VehicleSpot;
import com.base.model.VehicleType;
import com.base.service.api.ManagerService;
import com.base.service.api.ParkingLotService;
import com.base.service.api.RateCardService;
import com.base.service.api.VehicleSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImpl implements ManagerService {

  @Autowired
  ParkingLotService parkingLotService;

  @Autowired
  RateCardService rateCardService;

  @Autowired
  VehicleSpotService vehicleSpotService;

  Map<String, VehicleSpot> vehicleSpotMapping = new HashMap<>();


  @Override
  public VehicleSpot assignSpot(String regNum, VehicleType type) {
    ParkingSpot spot = parkingLotService.getParkingSpot("1", SpotType.fromString(type.toString()));
    VehicleSpot vehicleSpot = null;
    if (spot != null) {
      vehicleSpot = vehicleSpotService.addVehicleSpot(regNum, "1", spot.getId(), System.currentTimeMillis());
      vehicleSpotMapping.put(regNum, vehicleSpot);

      System.out.println("Spot assigned to regNum : " + regNum + " spot : " + vehicleSpot);
      return vehicleSpot;
    }
    return null;


  }

  @Override
  public Double exitVehicle(String regNum, String parkingLotId) {


    VehicleSpot vehicleSpot = vehicleSpotMapping.get(regNum);
    Long time = vehicleSpot.getEntryTime();
    Double rate = rateCardService.getAmount(System.currentTimeMillis() - time);
    vehicleSpot.setExitTime(System.currentTimeMillis());
    vehicleSpot.setAmoutPaid(rate);

    System.out.println("Amount paid :" + rate);

    return rate;


  }

  @Override
  public List<VehicleSpot> getVehicleHistory(String regNum) {
    List<VehicleSpot> list =  vehicleSpotService.getVehicleSPots(regNum);
    System.out.println(list);
    return list;


  }
}
