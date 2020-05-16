package com.base.service.impl;

import com.base.model.ParkingLot;
import com.base.model.ParkingSpot;
import com.base.model.SlotStatus;
import com.base.model.SpotType;
import com.base.service.api.ParkingLotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

  Map<String, ParkingLot> parkingLotMap = new HashMap<>();
  Map<String, String> vehicleSpotMap = new HashMap<>();

  @PostConstruct
  public void intialise() {
    this.addParkingLot(20, 10);
  }


  @Override
  public ParkingLot addParkingLot(Integer twoWheelSlots, Integer fourWheelSlots) {

    List<ParkingSpot> twoWheeler = new ArrayList<>();
    List<ParkingSpot> fourWheeler = new ArrayList<>();

    Map<SlotStatus, List<ParkingSpot>> twoWheelerMap = new HashMap<>();
    Map<SlotStatus, List<ParkingSpot>> fourWheelerMap = new HashMap<>();

    for (int i = 0; i < twoWheelSlots; i++) {
      ParkingSpot parkingSpot = ParkingSpot.builder().name("PS" + i).occupied(false).type(SpotType.TWO_WHEELER).build();
      twoWheeler.add(parkingSpot);
    }

    for (int i = 0; i < fourWheelSlots; i++) {
      ParkingSpot parkingSpot = ParkingSpot.builder().name("PS" + i).occupied(false).type(SpotType.FOUR_WHEELER).build();
      fourWheeler.add(parkingSpot);
    }
    ParkingLot parkingLot = new ParkingLot();
    parkingLot.setId("1");
    twoWheelerMap.put(SlotStatus.FREE, twoWheeler);
    twoWheelerMap.put(SlotStatus.OCCUPIED, new ArrayList<>());

    fourWheelerMap.put(SlotStatus.FREE, fourWheeler);
    fourWheelerMap.put(SlotStatus.OCCUPIED, new ArrayList<>());

    parkingLot.setTwoWheeler(twoWheelerMap);
    parkingLot.setFourWheeler(twoWheelerMap);

    parkingLotMap.put(parkingLot.getId(), parkingLot);

    System.out.println("created parking lot :" +  parkingLot);
    return parkingLot;


  }

  @Override
  public ParkingSpot getParkingSpot(String parkingLotId, SpotType spotType) {

    ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
    if (parkingLot != null) {

      if (SpotType.TWO_WHEELER.equals(spotType)) {
        List<ParkingSpot> spots = parkingLot.getTwoWheeler().get(SlotStatus.FREE);
        ParkingSpot spot = spots.remove(0);
        return spot;
      } else {
        List<ParkingSpot> spots = parkingLot.getFourWheeler().get(SlotStatus.FREE);
        ParkingSpot spot = spots.remove(0);
        return spot;
      }
    }
    return null;


  }

  @Override
  public void addVehicleSpotMap(String regNum, String spotId) {
    vehicleSpotMap.put(regNum, spotId);
  }

  @Override
  public String getSpotId(String regNum) {
    return vehicleSpotMap.get(regNum);
  }
}
