package com.bms.controller;

import com.bms.pojo.request.AddBookingRequest;
import com.bms.pojo.response.AddBookingResponse;
import com.bms.service.api.BookingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {


  @Autowired
  BookingManagerService bookingManagerService;


  @PostMapping("/create")
  AddBookingResponse createBooking(@RequestBody AddBookingRequest addBookingRequest) {
    return bookingManagerService.createBooking(addBookingRequest);
  }



}
