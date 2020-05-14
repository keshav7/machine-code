package com.base.timeline.service.pubsub;

import com.base.timeline.dto.PostRequest;

import java.util.Random;
import java.util.UUID;

public class QueueProducer implements Runnable{

  QueueService queueService;

  public QueueProducer(QueueService queueService) {
    this.queueService = queueService;
  }

  @Override
  public void run() {
    Random random = new Random();
    while (true) {

      PostRequest postRequest = PostRequest.builder().post(UUID.randomUUID().toString()).userId("U" + random.nextInt(200)).build();
      queueService.addPost(postRequest);
      System.out.println("Post created" + postRequest);

      try {
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        e.printStackTrace();  // TODO impl
      }
    }
  }
}
