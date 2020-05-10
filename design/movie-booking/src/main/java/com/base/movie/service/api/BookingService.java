package com.base.movie.service.api;

import com.base.movie.model.Booking;

import java.util.List;

public interface BookingService {

  Booking bookSeat(String userId, String seatId, String showId);

  List<Booking> getBookings(String showId);

}
