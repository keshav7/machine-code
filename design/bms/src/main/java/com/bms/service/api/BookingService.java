package com.bms.service.api;

import com.bms.model.Booking;
import com.bms.pojo.request.AddBookingRequest;

import java.util.List;

public interface BookingService {

  Booking createBooking(AddBookingRequest request);

  List<Booking> getBookings(String showId);
}
