package com.base.cabby.service.impl;

import com.base.cabby.dto.TripSearchRequest;
import com.base.cabby.model.Trip;
import com.base.cabby.model.TripStatus;
import com.base.cabby.service.api.TripService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TripServiceImpl implements TripService {

  List<Trip> trips =  new ArrayList<>();

  @Override
  public Trip createTrip(String src, String dest, String cabRegNum, String requestId) {
    Trip trip = Trip.builder().tripStatus(TripStatus.CREATED).cabRegNumber(cabRegNum)
        .src(src)
        .dest(dest)
        .id(UUID.randomUUID().toString())
        .requestId(requestId).build();

    trips.add(trip);
    return trip;
  }

  @Override
  public Trip updateTrip(String id, TripStatus status) {
    List<Trip> trips = searchTrip(TripSearchRequest.builder().requestId(id).build());
    Trip trip = null;
    if (!trips.isEmpty()) {
      trip = trips.get(0);
      trip.setTripStatus(TripStatus.COMPLETED);

    }
    return trip;
  }

  @Override
  public List<Trip> searchTrip(TripSearchRequest request) {
    List<Trip> tripResult = new ArrayList<>();
    for (Trip trip : trips) {
      if (trip.getRequestId().equals(request.getRequestId())) {
        tripResult.add(trip);
      }
    }
    return tripResult;
  }

  @Override
  public List<Trip> getTrips() {
    return trips;  // TODO impl
  }
}
