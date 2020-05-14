package com.base.timeline.service.pubsub;

import com.base.timeline.dto.PostRequest;
import com.base.timeline.service.api.OrchService;

public class QueueConsumer implements Runnable {

  private QueueService queueService;
  private OrchService orchService;

  public QueueConsumer(QueueService queueService, OrchService orchService) {
    this.queueService = queueService;
    this.orchService = orchService;
  }

  @Override
  public void run() {
    while (true) {
      PostRequest postRequest = queueService.getPost();
      if (postRequest != null) {
        System.out.println("Post consumed" + postRequest);
        orchService.updateTimeline(postRequest);
      }

      try {
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        e.printStackTrace();  // TODO impl
      }
    }
  }
}
