package com.base.cab_booking.service.impl;

import com.base.cab_booking.data.request.BookingRequest;
import com.base.cab_booking.core.response.ClientResponse;
import com.base.cab_booking.service.api.BookingService;
import com.base.cab_booking.service.api.CabService;
import com.base.cab_booking.service.api.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  CabService cabService;

  @Autowired
  TripService tripService;

  @Override
  public ClientResponse bookCab(BookingRequest bookingRequest) {
    return null;  // TODO impl
  }
}
