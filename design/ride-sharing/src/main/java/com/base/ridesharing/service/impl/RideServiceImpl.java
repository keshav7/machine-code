package com.base.ridesharing.service.impl;

import com.base.ridesharing.data.BookRideSpec;
import com.base.ridesharing.domain.Ride;
import com.base.ridesharing.service.api.RideService;
import com.base.ridesharing.service.api.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;

@Service
public class RideServiceImpl implements RideService {

  @Autowired
  TripService tripService;


  public ConcurrentHashMap<String, List<Ride>> ridesMap;


  public RideServiceImpl() {
    this.ridesMap = new ConcurrentHashMap<>();
  }

  @Override
  public void AddRide(Ride ride) {

    String id = UUID.randomUUID().toString();

    String route = getRoute(ride);
    List<Ride> rides = ridesMap.get(route);
    if (!CollectionUtils.isEmpty(rides)) {
      rides.add(ride);
    } else {
      List<Ride> list = Collections.synchronizedList(new ArrayList<Ride>());
      list.add(ride);
      ridesMap.put(route, list);
    }
  }

  @Override
  public Ride bookRide(BookRideSpec spec) {

    Ride ride = getLeastDurationRide(getRoute(spec.getStartLocation(), spec.getEndLocation()));
    return ride;
  }

  private Ride getLeastDurationRide(String route) {

    Ride result = null;
    if (ridesMap.containsKey(route)) {
      List<Ride> rides = ridesMap.get(route);
      Double duration = Double.MAX_VALUE;
      for (Ride ride : rides) {
        if (ride.getDuration() < duration) {
          result = ride;
          duration = ride.getDuration();
        }
      }

    }
    return result;
  }

  private String getRoute(Ride ride) {
    return ride.getStartLocation() + "," + ride.getEndLocation();
  }

  private String getRoute(String startLoc, String endLoc) {
    return startLoc + "," + endLoc;
  }

  


}
