package com.base.cab_booking.service.api;


import com.base.cab_booking.data.request.BookingRequest;
import com.base.cab_booking.core.response.ClientResponse;

public interface BookingService {

  ClientResponse bookCab(BookingRequest bookingRequest);
}
