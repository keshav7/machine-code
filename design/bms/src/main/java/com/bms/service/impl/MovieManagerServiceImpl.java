package com.bms.service.impl;

import com.bms.model.Booking;
import com.bms.model.BookingSeat;
import com.bms.model.CinemaSeat;
import com.bms.model.Show;
import com.bms.service.api.BookingManagerService;
import com.bms.service.api.BookingSeatService;
import com.bms.service.api.BookingService;
import com.bms.service.api.CinemaSeatService;
import com.bms.service.api.MovieManagerService;
import com.bms.service.api.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieManagerServiceImpl implements MovieManagerService {

  @Autowired
  BookingManagerService bookingManagerService;

  @Autowired
  CinemaSeatService cinemaSeatService;

  @Autowired
  BookingService bookingService;

  @Autowired
  ShowService showService;

  @Autowired
  BookingSeatService bookingSeatService;

  @Override
  public List<CinemaSeat> fetchAvailableSeats(String showId) {

    Show show = showService.getShow(showId);

      String cinemaId = show.getCinemaId();

    List<CinemaSeat> cinemaSeats = cinemaSeatService.getCinemaSeats(cinemaId);

    List<Booking> bookings = bookingService.getBookings(showId);

    List<BookingSeat> bookedSeats = new ArrayList<>();

    for (Booking booking : bookings) {
      bookedSeats.addAll(bookingSeatService.getBookingSeats(booking.getId()));
    }


    List<CinemaSeat> availaibleSeats = new ArrayList<>();

    for (CinemaSeat cinemaSeat : cinemaSeats) {

      String id = cinemaSeat.getId();

      Boolean bookedFlag = false;
      for (BookingSeat  bookingSeat : bookedSeats) {

        if (bookingSeat.getSeatId().equals(id)) {
          bookedFlag = true;
          break;
        }
      }


      if (!bookedFlag) {
        availaibleSeats.add(cinemaSeat);
      }
    }

    return availaibleSeats;

  }
}
