package com.base.ridesharing.service.api;

import com.base.ridesharing.data.BookRideSpec;
import com.base.ridesharing.domain.Ride;

public interface RideService {

  void AddRide(Ride ride);

  Ride bookRide(BookRideSpec spec);

}
