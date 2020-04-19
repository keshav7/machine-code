package com.base.parkinglot.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLot {

  private List<Floor> floorList;
  private List<SpotHistory> spotHistoryList;

}