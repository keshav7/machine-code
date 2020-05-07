package com.base.cab_book.service;

import com.base.cab_book.model.Event;
import com.base.cab_book.service.api.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

public class EventConsumer implements Runnable {

  @Autowired
  EventQueueService queueService;

  @Autowired
  BookingService bookingService;

  public EventConsumer(EventQueueService queueService, BookingService bookingService) {
    this.queueService = queueService;
    this.bookingService = bookingService;
  }

  @Override
  public void run() {

    while (true) {
      Event event = queueService.getEvent();
      if (event != null) {
        bookingService.handleEvent(event);
        System.out.println("Event consumed");
      }

      try {
        Thread.sleep(6000);
      } catch (InterruptedException e) {
        e.printStackTrace();  // TODO impl
      }

    }
  }

}
