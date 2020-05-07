package com.base.cab_book.service.impl;

import com.base.cab_book.model.Cab;
import com.base.cab_book.model.CabType;
import com.base.cab_book.service.EventQueueService;
import com.base.cab_book.service.api.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;

@Service
public class CabServiceImpl implements CabService {

  @Autowired
  EventQueueService eventQueueService;


  ArrayBlockingQueue<Cab> sedanQueue = new ArrayBlockingQueue<>(10);
  ArrayBlockingQueue<Cab> compactQueue = new ArrayBlockingQueue<>(10);
  ArrayBlockingQueue<Cab> suvQueue = new ArrayBlockingQueue<>(10);

  HashMap<String, Cab> cabs = new HashMap<>();


  @Override
  public Cab getCab(CabType type) {
    switch (type) {
      case SUV:
        return suvQueue.poll();
      case SEDAN:
        return sedanQueue.poll();
      case COMPACT:
        return compactQueue.poll();
    }
    return null;
  }

  @Override
  public Cab addCab(Cab cab) {
    switch (cab.getType()) {
      case SUV : suvQueue.offer(cab);
      break;
      case SEDAN : sedanQueue.offer(cab);
      break;
      case COMPACT : compactQueue.offer(cab);
      break;

    }

    return cab;  // TODO impl
  }
}
