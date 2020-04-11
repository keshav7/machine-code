package com.base.ridesharing.data;

import com.base.ridesharing.enums.RideType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRideSpec {

  String userId;
  RideType type;
  String startLocation;
  String endLocation;

}
