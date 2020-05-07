package com.base.cab_book.service.api;

import com.base.cab_book.model.Event;
import com.base.cab_book.model.Request;

public interface BookingService {

  void bookCab(Request request);

  void handleEvent(Event event);
}
