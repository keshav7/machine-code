package com.base.callaggregator.service.pubsub;

import com.base.callaggregator.model.Call;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

@Service
public class RankOneQueueService {

  private static int SIZE = 1000;
  ArrayBlockingQueue<Call> pQueue = new ArrayBlockingQueue(SIZE);

  public void addCall(Call call) {

    if (pQueue.size() < SIZE) {
      System.out.println("Call added to rank1 queue" + call);
      pQueue.offer(call);
    }
  }

  public Call fetchCall() {
    return pQueue.poll();
  }


}
