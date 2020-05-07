package com.base.cab_book.service.impl;

import com.base.cab_book.model.Cab;
import com.base.cab_book.model.Request;
import com.base.cab_book.model.Trip;
import com.base.cab_book.model.TripStatus;
import com.base.cab_book.service.api.TripService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TripServiceImpl implements TripService {

  Map<String, Trip> tripMap = new HashMap<>();


  @Override
  public Trip createTrip(Request request, Cab cab) {

    Trip trip = fromDto(request, cab);
    tripMap.put(trip.getId(), trip);

    System.out.println("Trip created" + trip);
    return trip;
  }

  @Override
  public void updateTrip(String id, TripStatus status) {
    Trip trip = tripMap.get(id);
    trip.setStatus(status);
  }


  Trip fromDto(Request request, Cab cab) {

    return Trip.builder()
        .id(UUID.randomUUID().toString())
        .src(request.getSrc())
        .dest(request.getDest())
        .cabNum(cab.getRegNum())
        .status(TripStatus.CREATED)
        .build();

  }
}
