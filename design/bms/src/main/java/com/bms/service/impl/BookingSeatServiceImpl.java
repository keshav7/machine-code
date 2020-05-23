package com.bms.service.impl;

import com.bms.model.BookingSeat;
import com.bms.pojo.request.BookingSeatRequest;
import com.bms.service.api.BookingSeatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingSeatServiceImpl implements BookingSeatService {

  Map<String, List<BookingSeat>> bookingIdBookingSeatMap = new HashMap<>();

  @Override
  public BookingSeat createBookingSeat(BookingSeatRequest bookingSeatRequest) {

    BookingSeat bookingSeat = BookingSeat.builder()
        .seatId(bookingSeatRequest.getSeatId())
        .build();

    List<BookingSeat> bookingSeats = bookingIdBookingSeatMap.get(bookingSeatRequest.getBookingId());
    if (bookingSeats == null || bookingSeats.isEmpty()) {
      bookingSeats = new ArrayList<>();

    }

    bookingSeats.add(bookingSeat);
    bookingIdBookingSeatMap.put(bookingSeatRequest.getBookingId(), bookingSeats);
    return bookingSeat;


  }

  @Override
  public List<BookingSeat> getBookingSeats(String bookingId) {
    return bookingIdBookingSeatMap.get(bookingId);
  }
}
