package com.base.cab_book.service;

import com.base.cab_book.model.Cab;
import com.base.cab_book.model.CabType;
import com.base.cab_book.service.api.BookingService;
import com.base.cab_book.service.api.CabService;
import com.base.cab_book.service.api.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ManagerServiceImpl implements ManagerService {


  @Autowired
  CabService cabService;

  @Autowired
  PQueue pQueue;

  @Autowired
  EventQueueService eventQueueService;

  @Autowired
  BookingService bookingService;




  @Override
  public void initialise() {
    cabService.addCab(getCab());
    cabService.addCab(getCab());
    cabService.addCab(getCab());
    cabService.addCab(getCab());
    cabService.addCab(getCab());

    RequestProducer rp1 = new RequestProducer(pQueue);
    Consumer rc1 = new Consumer(pQueue, bookingService);
    EventConsumer eventConsumer = new EventConsumer(eventQueueService, bookingService);

    ExecutorService tpool = Executors.newFixedThreadPool(5);
    ExecutorService ePool = Executors.newFixedThreadPool(5);

    tpool.submit(() -> {
      try {
        rp1.run();
      } catch(Exception e) {
        System.out.println("E" + e);
      }
    });

    tpool.submit(() -> {
      try {
        rc1.run();
      } catch(Exception e) {
        System.out.println("E" + e);
      }
    });

    ePool.submit(
        () -> {
          try {
            eventConsumer.run();
          } catch (Exception e) {

          }
        }
    );


  }



  private Cab getCab() {

    return Cab.builder()
        .regNum(UUID.randomUUID().toString())
        .type(CabType.SEDAN).build();

  }

}
