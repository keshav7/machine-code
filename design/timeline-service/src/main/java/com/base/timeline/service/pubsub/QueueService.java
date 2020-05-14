package com.base.timeline.service.pubsub;

import com.base.timeline.dto.PostRequest;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

@Service
public class QueueService {

  private static int SIZE = 3000;
  ArrayBlockingQueue<PostRequest> queue = new ArrayBlockingQueue(SIZE);

  public void addPost(PostRequest request) {

    queue.offer(request);
  }

  public PostRequest getPost() {

    return queue.poll();
  }

}
