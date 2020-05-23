package com.bms.controller;

import com.bms.model.Show;
import com.bms.pojo.request.AddShowRequest;
import com.bms.service.api.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

  @Autowired
  ShowService showService;


  @PostMapping("/add")
  Show addShow(@RequestBody AddShowRequest request) {
    return showService.addShow(request);
  }

  @PostMapping("/get")
  List<Show> getShows(String cinemaId) {

    return showService.getShowsByCinemaId(cinemaId);
  }

  //getAvailableSeats();
}
