package com.base.cab_booking.service.impl;

import com.base.cab_booking.data.request.SearchTripRequest;
import com.base.cab_booking.domain.Trip;
import com.base.cab_booking.service.api.TripService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

@Service
public class TripServiceImpl implements TripService {


  private List<Trip> tripsList;

  @PostConstruct
  public void init() {
    tripsList = new ArrayList<>();
  }


  @Override
  public Trip createTrip(Trip trip) {
    return null;  // TODO impl
  }

  @Override
  public Trip cancelTrip(String tripId) {
    return null;  // TODO impl
  }

  @Override
  public Trip completeTrip(String tripId) {
    return null;  // TODO impl
  }

  @Override
  public List<Trip> searchTrip(SearchTripRequest searchTripRequest) {
    return null;  // TODO impl
  }
}
