package com.base.cabby.service.pub_sub;

import com.base.cabby.model.CabRequest;
import com.base.cabby.model.CabType;
import com.base.cabby.service.api.QueueService;

import java.util.Random;
import java.util.UUID;

public class QueueProducer implements Runnable {

  QueueService queueService;
  CabType cabType;
  Random random = new Random();

  public QueueProducer(QueueService queueService, CabType cabType) {
    this.queueService = queueService;
    this.cabType = cabType;
  }

  @Override
  public void run() {
    while (true) {
      CabRequest cabRequest = CabRequest.builder()
          .src("S" + random.nextInt(10))
          .dest("D" + random.nextInt(10))
          .cabType(cabType)
          .userId(String.valueOf(random.nextInt(20)))
          .id(UUID.randomUUID().toString())
          .build();
      queueService.addNewRequest(cabRequest);
      System.out.println("Added new cab request :" + cabRequest);
      try {
        Thread.sleep(3000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
