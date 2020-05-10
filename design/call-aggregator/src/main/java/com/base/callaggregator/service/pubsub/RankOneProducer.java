package com.base.callaggregator.service.pubsub;


import com.base.callaggregator.model.Call;

import java.util.UUID;

public class RankOneProducer implements Runnable {

  RankOneQueueService queueService;

  public RankOneProducer(RankOneQueueService queueService) {
    this.queueService = queueService;
  }

  @Override
  public void run() {
    while (true) {
      String id = UUID.randomUUID().toString();
      queueService.addCall(Call.builder().id(id).name(id.substring(0, 3)).build());
      try {
        Thread.sleep(3000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
