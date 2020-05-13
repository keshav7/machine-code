package com.base.cabby.service.pub_sub;

import com.base.cabby.model.Cab;
import com.base.cabby.model.CabRequest;
import com.base.cabby.service.api.OrchestratorService;
import com.base.cabby.service.api.QueueService;

public class QueueConsumer implements Runnable {

  private QueueService queue;
  private OrchestratorService orchestratorService;
  private Cab cab;

  private Long RETRY_SLEEP = 3000L;
  private Long HANDLE_SLEEP = 5000L;


  public QueueConsumer(QueueService queue, OrchestratorService orchestratorService, Cab cab) {
    this.queue = queue;
    this.orchestratorService = orchestratorService;
    this.cab = cab;

  }


  @Override
  public void run() {

    while (true) {

      try {
        CabRequest cabRequest = queue.fetchRequest();
        if (cabRequest != null) {
          orchestratorService.assignRequest(cabRequest.getSrc(), cabRequest.getDest(), cab.getRegNum(), cabRequest.getId());
          Thread.sleep(HANDLE_SLEEP);
          orchestratorService.requestCompleted(cabRequest.getId());
        } else {
          Thread.sleep(RETRY_SLEEP);
        }

      } catch (Exception e) {
        // handle
      }
    }
  }
}