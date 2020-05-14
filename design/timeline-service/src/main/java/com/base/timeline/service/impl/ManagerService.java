package com.base.timeline.service.impl;

import com.base.timeline.service.api.OrchService;
import com.base.timeline.service.pubsub.QueueConsumer;
import com.base.timeline.service.pubsub.QueueProducer;
import com.base.timeline.service.pubsub.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ManagerService {

  @Autowired
  OrchService orchService;

  @Autowired
  QueueService queueService;


  public void initialise() {

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    QueueProducer producer = new QueueProducer(queueService);
    QueueConsumer consumer = new QueueConsumer(queueService, orchService);

    executorService.submit(
        () -> {
          producer.run();
        }
    );

    executorService.submit(() -> {
      consumer.run();
    });

  }
}
