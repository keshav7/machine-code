package com.base.cab_book.service.impl;

import com.base.cab_book.model.Cab;
import com.base.cab_book.model.Event;
import com.base.cab_book.model.EventType;
import com.base.cab_book.model.Request;
import com.base.cab_book.model.Trip;
import com.base.cab_book.model.TripStatus;
import com.base.cab_book.service.EventQueueService;
import com.base.cab_book.service.api.BookingService;
import com.base.cab_book.service.api.CabService;
import com.base.cab_book.service.api.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  CabService cabService;

  @Autowired
  TripService tripService;

  @Autowired
  EventQueueService eventQueueService;

  @Override
  public void bookCab(Request request) {
    Cab cab = cabService.getCab(request.getCabType());
    if (cab != null) {
      Trip trip = tripService.createTrip(request, cab);
      eventQueueService.addEvent(Event.builder()
          .cab(cab)
          .eventType(EventType.COMPLETED).tripId(trip.getId()).build());
    } else {

      System.out.println("cab not present, cannot serve request");
      //log message
    }
  }

  @Override
  public void handleEvent(Event event) {

    switch (event.getEventType()) {
      case STARTED:
        tripService.updateTrip(event.getTripId(), TripStatus.STARTED);
        break;
      case COMPLETED:
        tripService.updateTrip(event.getTripId(), TripStatus.COMPLETED);
        cabService.addCab(event.getCab());
        break;

    }
  }
}
