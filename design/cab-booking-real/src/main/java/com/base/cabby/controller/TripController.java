package com.base.cabby.controller;

import com.base.cabby.dto.TripSearchRequest;
import com.base.cabby.model.Trip;
import com.base.cabby.service.api.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

  @Autowired
  TripService tripService;

  @PostMapping("/search")
  List<Trip> searchTrips(@RequestBody TripSearchRequest tripSearchRequest) {

    return tripService.searchTrip(tripSearchRequest);

  }

  @GetMapping("/get-all")
  List<Trip> getTrips() {
    return tripService.getTrips();
  }

}
