package com.base.cab_book.service;

import com.base.cab_book.model.Request;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

@Service
public class PQueue {

  private static int SIZE = 100;

  private ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(SIZE);

  public ArrayBlockingQueue getQueue() {
    return queue;
  }

  public Boolean isFull() {
    return queue.size() < SIZE;
  }

  public Boolean addEntry(Request request) {

    return queue.offer(request);
  }

  public Request peek() {
    return queue.peek();
  }

}
