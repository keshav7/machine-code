package com.base.dream11.service.api;

import com.base.dream11.model.Event;

public interface EventService {

  Event addEvent(String input) throws InterruptedException;
}
