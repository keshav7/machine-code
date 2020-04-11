package com.base.design.service.impl;

import com.base.design.data.request.BookingRequest;
import com.base.design.domain.Cab;
import com.base.design.service.api.BookingService;
import com.base.design.service.api.CabService;
import com.base.design.service.api.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  CabService cabService;

  @Autowired
  TripService tripService;

  @Override
  public Cab bookCab(BookingRequest bookingRequest) {
    return null;  // TODO impl
  }
}
