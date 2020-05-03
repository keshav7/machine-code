package com.base.dream11.service;

import com.base.dream11.model.Event;
import com.base.dream11.service.api.QueueService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

@Service
public class QueueServiceImpl implements QueueService {

  ArrayBlockingQueue<Event> queue = new ArrayBlockingQueue<Event>(10000);

  public ArrayBlockingQueue<Event> getQueue() {
    return queue;
  }

  @Override
  public void addEvent(Event e) throws InterruptedException {
    queue.put(e);
  }

  @Override
  public Event getEvent() {
    if (!queue.isEmpty()) {
      return queue.poll();
    }
    return null;
  }



}
