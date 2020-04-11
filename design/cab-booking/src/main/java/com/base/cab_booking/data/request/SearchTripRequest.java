package com.base.cab_booking.data.request;

import com.base.cab_booking.enums.TripStatus;
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
