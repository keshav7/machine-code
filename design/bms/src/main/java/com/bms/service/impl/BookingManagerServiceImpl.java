package com.bms.service.impl;

import com.bms.model.Booking;
import com.bms.pojo.request.AddBookingRequest;
import com.bms.pojo.request.BookingSeatRequest;
import com.bms.pojo.response.AddBookingResponse;
import com.bms.service.api.BookingManagerService;
import com.bms.service.api.BookingSeatService;
import com.bms.service.api.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingManagerServiceImpl implements BookingManagerService {

  @Autowired
  BookingService bookingService;

  @Autowired
  BookingSeatService bookingSeatService;

  @Override
  public AddBookingResponse createBooking(AddBookingRequest request) {


    Booking booking = bookingService.createBooking(request);
    for (String seatId : request.getSeatIds()) {

      BookingSeatRequest bookingSeatRequest = BookingSeatRequest.builder()
          .bookingId(booking.getId())
          .seatId(seatId)
          .build();

      bookingSeatService.createBookingSeat(bookingSeatRequest);


    }
    return AddBookingResponse.builder().bookingId(booking.getId()).build();
  }
}
