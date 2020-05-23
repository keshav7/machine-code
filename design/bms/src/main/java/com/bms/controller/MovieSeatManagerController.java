package com.bms.controller;


import com.bms.model.CinemaSeat;
import com.bms.pojo.request.GetAvailableSeatsRequest;
import com.bms.service.api.MovieManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie-seat")
public class MovieSeatManagerController {

  @Autowired
  MovieManagerService movieManagerService;


  @PostMapping("/available")
  List<CinemaSeat> getAvailableSeats(@RequestBody GetAvailableSeatsRequest request) {
    return movieManagerService.fetchAvailableSeats(request.getShowId());


  }


}
