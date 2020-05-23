package com.bms.controller;

import com.bms.model.Cinema;
import com.bms.model.CinemaSeat;
import com.bms.pojo.request.AddCinemaRequest;
import com.bms.pojo.request.AddCinemaSeatRequest;
import com.bms.service.api.CinemaSeatService;
import com.bms.service.api.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

  @Autowired
  CinemaService cinemaService;

  @Autowired
  CinemaSeatService cinemaSeatService;



  @PostMapping("/add")
  Cinema addCinema(@RequestBody AddCinemaRequest request) {

    return cinemaService.addCinema(request.getName(), request.getCityId());

  }

  @PostMapping("/seat/add")
  CinemaSeat addSeat(@RequestBody AddCinemaSeatRequest request) {

    return cinemaSeatService.addCinemaSeat(request.getCinemaId(), request.getSeatName());

  }
}
