package com.base.cab_book.service.api;

import com.base.cab_book.model.Cab;
import com.base.cab_book.model.Request;
import com.base.cab_book.model.Trip;
import com.base.cab_book.model.TripStatus;

public interface TripService {

  Trip createTrip(Request request, Cab cab);
  void updateTrip(String id, TripStatus status);
}
