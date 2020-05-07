package com.base.cab_book.service;

import com.base.cab_book.model.Request;
import com.base.cab_book.service.api.BookingService;
import org.springframework.beans.factory.annotation.Autowired;


public class Consumer implements Runnable {

  @Autowired
  PQueue pQueue;

  @Autowired
  BookingService bookingService;


  public Consumer(PQueue pQueue, BookingService bookingService) {
    this.pQueue = pQueue;
    this.bookingService = bookingService;
  }

  @Override
  public void run() {

    while (true) {
      Request request = pQueue.peek();
      if (request != null) {
        bookingService.bookCab(request);
      }
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();  // TODO impl
      }
    }
  }
}