package com.base.movie.service.impl;

import com.base.movie.model.Booking;
import com.base.movie.model.Cinema;
import com.base.movie.model.CinemaSeat;
import com.base.movie.model.Movie;
import com.base.movie.model.Show;
import com.base.movie.service.api.BookingService;
import com.base.movie.service.api.CinemaSeatsService;
import com.base.movie.service.api.CinemaService;
import com.base.movie.service.api.ManagerService;
import com.base.movie.service.api.MovieService;
import com.base.movie.service.api.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

  @Autowired
  BookingService bookingService;
  @Autowired
  MovieService movieService;
  @Autowired
  CinemaService cinemaService;
  @Autowired
  CinemaSeatsService cinemaSeatsService;
  @Autowired
  ShowService showService;

  @Override
  public void initialise() {
    Movie movie = movieService.addMovie("movieA");

    Cinema cinema = cinemaService.addCinema("cinemaA");

    CinemaSeat cinemaSeat1 = cinemaSeatsService.addSeat(cinema.getId());
    CinemaSeat cinemaSeat2 = cinemaSeatsService.addSeat(cinema.getId());
    CinemaSeat cinemaSeat3 = cinemaSeatsService.addSeat(cinema.getId());
    CinemaSeat cinemaSeat4 = cinemaSeatsService.addSeat(cinema.getId());
    CinemaSeat cinemaSeat5 = cinemaSeatsService.addSeat(cinema.getId());
    CinemaSeat cinemaSeat6 = cinemaSeatsService.addSeat(cinema.getId());
    CinemaSeat cinemaSeat7 = cinemaSeatsService.addSeat(cinema.getId());
    CinemaSeat cinemaSeat8 = cinemaSeatsService.addSeat(cinema.getId());
    CinemaSeat cinemaSeat9 = cinemaSeatsService.addSeat(cinema.getId());
    CinemaSeat cinemaSeat10 = cinemaSeatsService.addSeat(cinema.getId());

    Show show = showService.addShow(cinema.getId(), movie.getId());

    Booking bookingA = bookingService.bookSeat("A", cinemaSeat1.getId(), show.getId());
    Booking bookingB = bookingService.bookSeat("B", cinemaSeat1.getId(), show.getId());
    Booking bookingC = bookingService.bookSeat("C", cinemaSeat2.getId(), show.getId());
    Booking bookingD = bookingService.bookSeat("D", cinemaSeat3.getId(), show.getId());

    List<CinemaSeat> cinemaSeatList = getAvailaibleSeats(show.getId());
  }

  @Override
  public Movie addMovie(String name) {
    return movieService.addMovie(name);
  }

  @Override
  public Cinema addCinema(String name) {
    return cinemaService.addCinema(name);
  }

  @Override
  public CinemaSeat addCinemaSeats(Cinema cinema) {
    return cinemaSeatsService.addSeat(cinema.getId());
  }

  @Override
  public Show addShow(Cinema cinema, Movie movie) {
    return showService.addShow(cinema.getId(), movie.getId());
  }

  @Override
  public void bookSeat(String user, String showId) {
    Show show = showService.getShow(showId);
    if (bookingService.getBookings(showId).size() < cinemaSeatsService.getSeats(show.getCinemaId()).size()) {
      List<CinemaSeat> availableSeats = getAvailaibleSeats(showId);
      if (!availableSeats.isEmpty()) {
        bookingService.bookSeat(user, availableSeats.get(0).getId(), showId);
      }
    }
  }

  @Override
  public List<CinemaSeat> getAvailaibleSeats(String showId) {
    Show show = showService.getShow(showId);
    List<Booking> bookings = bookingService.getBookings(showId);
    List<CinemaSeat> cinemaSeats = cinemaSeatsService.getSeats(show.getCinemaId());

    List<CinemaSeat> result = new ArrayList<>();
    Boolean booked = false;

    for (CinemaSeat cinemaSeat : cinemaSeats) {
      booked = false;
      for (Booking booking : bookings) {
        if (booking.getSeatId().equals(cinemaSeat.getId())) {
          booked = true;
          break;
        }
      }
      if (!booked) {
        result.add(cinemaSeat);
      }
    }

    System.out.println("Available seats" + result);
    return result;
  }
}