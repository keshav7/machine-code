package com.base.cab_booking.service.api;

import com.base.cab_booking.data.request.SearchTripRequest;
import com.base.cab_booking.domain.Trip;

import java.util.List;

public interface TripService {

  Trip createTrip(Trip trip);
  Trip cancelTrip(String tripId);
  Trip completeTrip(String tripId);
  List<Trip> searchTrip(SearchTripRequest searchTripRequest);

}
