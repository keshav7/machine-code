package com.bms.service.api;

import com.bms.model.BookingSeat;
import com.bms.pojo.request.BookingSeatRequest;

import java.util.List;

public interface BookingSeatService {

  BookingSeat createBookingSeat(BookingSeatRequest bookingSeatRequest);

  List<BookingSeat> getBookingSeats(String bookingId);

}
