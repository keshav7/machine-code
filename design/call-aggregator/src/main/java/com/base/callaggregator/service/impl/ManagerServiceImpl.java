package com.base.callaggregator.service.impl;


import com.base.callaggregator.service.api.CallAggregator;
import com.base.callaggregator.service.api.ManagerSevice;
import com.base.callaggregator.service.pubsub.RankOneConsumer;
import com.base.callaggregator.service.pubsub.RankOneProducer;
import com.base.callaggregator.service.pubsub.RankOneQueueService;
import com.base.callaggregator.service.pubsub.RankThreeConsumer;
import com.base.callaggregator.service.pubsub.RankThreeQueueService;
import com.base.callaggregator.service.pubsub.RankTwoConsumer;
import com.base.callaggregator.service.pubsub.RankTwoQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ManagerServiceImpl implements ManagerSevice {


  @Autowired
  RankOneQueueService rankOneQueueService;
  @Autowired
  RankTwoQueueService rankTwoQueueService;
  @Autowired
  RankThreeQueueService rankThreeQueueService;

  @Autowired
  CallAggregator callAggregator;

  @Override
  public void initialise() {

    ExecutorService exeecutorService = Executors.newFixedThreadPool(5);
    RankOneProducer rankOneProducer = new RankOneProducer(rankOneQueueService);

    RankOneConsumer rankOneConsumer = new RankOneConsumer(rankOneQueueService, callAggregator);
    RankTwoConsumer rankTwoConsumer = new RankTwoConsumer(rankTwoQueueService, callAggregator);
    RankThreeConsumer rankThreeConsumer = new RankThreeConsumer(rankThreeQueueService, callAggregator);

    exeecutorService.submit(
        () -> {
          rankOneProducer.run();
        }
    );

    exeecutorService.submit(
        () -> {
          rankOneConsumer.run();
        }
    );

    exeecutorService.submit(
        () -> {
          rankTwoConsumer.run();
        }
    );

    exeecutorService.submit(
        () -> {
          rankThreeConsumer.run();
        }
    );

  }
}
