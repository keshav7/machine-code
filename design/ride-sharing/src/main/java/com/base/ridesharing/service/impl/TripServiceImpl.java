package com.base.ridesharing.service.impl;

import com.base.ridesharing.domain.Trip;
import com.base.ridesharing.service.api.TripService;

import java.util.List;

public class TripServiceImpl implements TripService {

  List<Trip> tripsList;

  @Override
  public void addTrip(Trip trip) {
    tripsList.add(trip);
  }
}
