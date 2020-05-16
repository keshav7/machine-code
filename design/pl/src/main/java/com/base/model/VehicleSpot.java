package com.base.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSpot {

  String vehicleNum;
  String parkingLotId;
  String spotId;
  Long entryTime;
  Long exitTime;
  Double amoutPaid;

}
