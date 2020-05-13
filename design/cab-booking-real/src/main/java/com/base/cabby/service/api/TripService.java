package com.base.cabby.service.api;

import com.base.cabby.dto.TripSearchRequest;
import com.base.cabby.model.Trip;
import com.base.cabby.model.TripStatus;

import java.util.List;

public interface TripService {

  Trip createTrip(String src, String dest, String cabRegNum, String requestId);

  Trip updateTrip(String id, TripStatus status);

  List<Trip> searchTrip(TripSearchRequest request);

  List<Trip> getTrips();

}
