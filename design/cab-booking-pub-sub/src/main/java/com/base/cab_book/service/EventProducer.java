package com.base.cab_book.service;

import com.base.cab_book.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ArrayBlockingQueue;

public class EventProducer implements Runnable {

  @Autowired
  EventQueueService eventQueueService;

  ArrayBlockingQueue<Event> events = new ArrayBlockingQueue(10000);



  @Override
  public void run() {

    while (true) {

      if (!eventQueueService.isFull() && !events.isEmpty()) {
        eventQueueService.addEvent(events.peek());
        System.out.println("Produced event");
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();  // TODO impl
      }


    }


  }

  public void produceEvent(Event event) {

    events.offer(event);
  }
}
