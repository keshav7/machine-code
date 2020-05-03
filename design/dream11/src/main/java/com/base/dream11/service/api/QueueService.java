package com.base.dream11.service.api;

import com.base.dream11.model.Event;

public interface QueueService {
  void addEvent(Event e) throws InterruptedException;
  Event getEvent();
}
