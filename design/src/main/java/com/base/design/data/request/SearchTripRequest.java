package com.base.design.data.request;

import com.base.design.enums.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTripRequest {

  String userId;
  TripStatus status;


}
