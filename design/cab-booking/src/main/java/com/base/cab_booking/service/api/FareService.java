package com.base.cab_booking.service.api;


import com.base.cab_booking.data.request.GetFareRequestSpec;
import com.base.cab_booking.data.result.GetFareResponse;

public interface FareService {


  GetFareResponse getFare(GetFareRequestSpec spec);
}
