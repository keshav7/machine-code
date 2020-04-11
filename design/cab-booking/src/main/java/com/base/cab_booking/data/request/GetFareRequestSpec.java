package com.base.cab_booking.data.request;

import com.base.cab_booking.domain.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFareRequestSpec {

  Location startLocation;
  Location endLocation;
}
