package com.base.callaggregator.service.pubsub;

import com.base.callaggregator.model.Call;
import com.base.callaggregator.model.Rank;
import com.base.callaggregator.service.api.CallAggregator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class RankThreeConsumer implements Runnable {

  @Autowired
  RankThreeQueueService queueService;

  @Autowired
  CallAggregator callAggregator;

  public RankThreeConsumer(RankThreeQueueService queueService, CallAggregator callAggregator) {
    this.queueService = queueService;
    this.callAggregator = callAggregator;
  }

  @Override
  public void run() {
    while (true) {
      Call call = queueService.fetchCall();
      if (call != null) {
        if (new Random().nextInt(10) < 9) {
          callAggregator.callHandled(call, Rank.THREE);
        } else {
          callAggregator.escalateCall(call, Rank.THREE);
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
