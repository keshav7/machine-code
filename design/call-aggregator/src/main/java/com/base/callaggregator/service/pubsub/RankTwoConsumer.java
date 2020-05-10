package com.base.callaggregator.service.pubsub;

import com.base.callaggregator.model.Call;
import com.base.callaggregator.model.Rank;
import com.base.callaggregator.service.api.CallAggregator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class RankTwoConsumer implements Runnable {

  @Autowired
  RankTwoQueueService queueService;

  @Autowired
  CallAggregator callAggregator;

  public RankTwoConsumer(RankTwoQueueService queueService, CallAggregator callAggregator) {
    this.queueService = queueService;
    this.callAggregator = callAggregator;
  }

  @Override
  public void run() {
    while (true) {
      Call call = queueService.fetchCall();
      if (call != null) {
        if (new Random().nextInt(10) < 8) {
          callAggregator.callHandled(call, Rank.TWO);
        } else {
          callAggregator.escalateCall(call, Rank.TWO);
        }

      }
      try {
        Thread.sleep(2000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
