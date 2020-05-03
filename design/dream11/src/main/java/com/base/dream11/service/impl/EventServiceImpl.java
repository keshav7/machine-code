package com.base.dream11.service.impl;

import com.base.dream11.model.Event;
import com.base.dream11.model.EventType;
import com.base.dream11.service.api.EventService;
import com.base.dream11.service.api.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {

  @Autowired
  QueueService queueService;

  @Override
  public Event addEvent(String input) throws InterruptedException {
    Event event = new Event();
    event.setId(UUID.randomUUID().toString());
    List<String> list = Arrays.asList(input.split("\\s"));
    event.setEventType(EventType.fromString(list.get(0)));
    event.setPlayer(list.get(1));
    if (list.size() > 2) {
      event.setNumber(list.get(2));
    }
    queueService.addEvent(event);

    return event;
  }
}
