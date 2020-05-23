package com.bms.service.impl;

import com.bms.model.Booking;
import com.bms.pojo.request.AddBookingRequest;
import com.bms.service.api.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

  Map<String, List<Booking>> showBookingMap = new HashMap<>();

  @Override
  public Booking createBooking(AddBookingRequest request) {
    Booking booking = Booking.builder()
        .id(UUID.randomUUID().toString().substring(4, 8))
        .userId(request.getUserId())
        .createdTimeStamp(System.currentTimeMillis())
        .build();

    List<Booking> bookings = showBookingMap.get(request.getCinemaId());
    if (bookings == null || bookings.isEmpty()) {
      bookings = new ArrayList<>();
    }
    bookings.add(booking);
    showBookingMap.put(request.getShowId(), bookings);

    return booking;
  }

  @Override
  public List<Booking> getBookings(String showId) {

    return showBookingMap.get(showId);
  }
}
