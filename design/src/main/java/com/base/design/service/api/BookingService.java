package com.base.design.service.api;

import com.base.design.core.response.ClientResponse;
import com.base.design.data.request.BookingRequest;

public interface BookingService {

  ClientResponse bookCab(BookingRequest bookingRequest);
}
