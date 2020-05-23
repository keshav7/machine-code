package com.bms.service.api;


import com.bms.model.CinemaSeat;

import java.util.List;


public interface MovieManagerService {

  List<CinemaSeat> fetchAvailableSeats(String showId);
}
