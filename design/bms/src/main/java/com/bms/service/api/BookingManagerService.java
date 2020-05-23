package com.bms.service.api;

import com.bms.model.CinemaSeat;
import com.bms.pojo.request.AddBookingRequest;
import com.bms.pojo.response.AddBookingResponse;

import java.util.List;

public interface BookingManagerService {

  AddBookingResponse createBooking(AddBookingRequest request);



}
