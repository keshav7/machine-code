package com.base.movie.service.impl;

import com.base.movie.model.Booking;
import com.base.movie.service.api.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookingServiceImpl implements BookingService {

  ConcurrentHashMap<String, List<Booking>> bookings = new ConcurrentHashMap<>();

  @Override
  public Booking bookSeat(String userId, String seatId, String showId) {
    if (!bookings.containsKey(showId)) {
      bookings.put(showId, new ArrayList<>());
    }
    for (Booking booking : bookings.get(showId)) {

      if (booking.getSeatId().equals(seatId)) {
        System.out.println("seat already booked");
        return null;
      }
    }
    Booking booking = Booking.builder().seatId(seatId).showId(showId).userId(userId).build();

    bookings.get(showId).add(booking);
    System.out.println("Booking done" + booking);
    return booking;
  }

  @Override
  public List<Booking> getBookings(String showId) {
    return bookings.get(showId);
  }
}
