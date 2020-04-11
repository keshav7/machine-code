package com.base.design.service.api;

import com.base.design.data.request.SearchTripRequest;
import com.base.design.domain.Trip;

import java.util.List;

public interface TripService {

  Trip createTrip(Trip trip);
  Trip cancelTrip(String tripId);
  Trip completeTrip(String tripId);
  List<Trip> searchTrip(SearchTripRequest searchTripRequest);

}
