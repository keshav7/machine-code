package com.base.cabby.service.impl;

import com.base.cabby.model.Trip;
import com.base.cabby.model.TripStatus;
import com.base.cabby.service.api.OrchestratorService;
import com.base.cabby.service.api.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrchestratorServiceImpl implements OrchestratorService {

  @Autowired
  TripService tripService;

  @Override
  public void assignRequest(String src, String dest, String cabRegNum, String requestId) {
    Trip trip = tripService.createTrip(src, dest, cabRegNum, requestId);
    System.out.println("New trip created :" + trip);
  }

  @Override
  public void requestCompleted(String requestId) {
    Trip trip = tripService.updateTrip(requestId, TripStatus.COMPLETED);
    System.out.println("Trip : " + trip.getId() + TripStatus.COMPLETED);
  }
}
