package com.base.cabby.service.pub_sub;

import com.base.cabby.model.CabRequest;
import com.base.cabby.service.api.QueueService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

@Service
public class QueueServiceImpl implements QueueService {

  public static int SIZE = 100;

  ArrayBlockingQueue<CabRequest> arrayBlockingQueue = new ArrayBlockingQueue(SIZE);


  @Override
  public void addNewRequest(CabRequest request) {

    arrayBlockingQueue.offer(request);
  }

  @Override
  public CabRequest fetchRequest() {
    return arrayBlockingQueue.poll();
  }


}
