package com.base.cab_book.service;

import com.base.cab_book.model.CabType;
import com.base.cab_book.model.Event;
import com.base.cab_book.model.Request;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

public class RequestProducer implements Runnable {

  @Autowired
  PQueue queueService;

  public RequestProducer(PQueue queueService) {
    this.queueService = queueService;
  }

  @Override
  public void run() {

    while (true) {

      if (queueService.isFull()) {
        queueService.addEntry(getRequestEvent());
        System.out.println("Produced event");
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();  // TODO impl
      }


    }


  }

  public Request getRequestEvent() {

    return Request.builder()
        .cabType(CabType.SEDAN)
        .createdAt(System.currentTimeMillis())
        .src("A")
        .dest("Z")
        .userId(UUID.randomUUID().toString())
        .id(UUID.randomUUID().toString())
        .build();

  }
  
}
