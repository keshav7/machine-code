package com.base.cab_book.service;

import com.base.cab_book.model.Event;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

@Service
public class EventQueueService {

  public static int SIZE = 10000;

  ArrayBlockingQueue<Event> queue = new ArrayBlockingQueue(SIZE);

  public Event getEvent() {

    return queue.peek();
  }

  public Boolean addEvent(Event event) {
    return queue.offer(event);

  }

  public Boolean isFull() {
    return queue.size() < SIZE;
  }
}
