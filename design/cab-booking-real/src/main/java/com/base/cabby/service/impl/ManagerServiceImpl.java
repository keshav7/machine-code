package com.base.cabby.service.impl;

import com.base.cabby.model.Cab;
import com.base.cabby.model.CabType;
import com.base.cabby.service.api.ManagerService;
import com.base.cabby.service.api.OrchestratorService;
import com.base.cabby.service.api.QueueService;
import com.base.cabby.service.pub_sub.QueueConsumer;
import com.base.cabby.service.pub_sub.QueueProducer;
import com.base.cabby.service.pub_sub.QueueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ManagerServiceImpl implements ManagerService {


  @Autowired
  OrchestratorService orchestratorService;


  @Override
  public void initialise() {

    QueueService compactQueueService = new QueueServiceImpl();
    QueueService suvQueueService = new QueueServiceImpl();
    QueueService sedanQueueService = new QueueServiceImpl();

    Cab cab01 = Cab.builder().regNum("ABC").type(CabType.COMPACT).build();
    Cab cab02 = Cab.builder().regNum("DEF").type(CabType.COMPACT).build();
    Cab cab03 = Cab.builder().regNum("GHI").type(CabType.COMPACT).build();
    Cab cab04 = Cab.builder().regNum("MNO").type(CabType.COMPACT).build();

    QueueConsumer compactQueueConsumer01 = new QueueConsumer(compactQueueService, orchestratorService, cab01);
    QueueConsumer compactQueueConsumer02 = new QueueConsumer(compactQueueService, orchestratorService, cab02);
    QueueConsumer compactQueueConsumer03 = new QueueConsumer(compactQueueService, orchestratorService, cab03);
    QueueConsumer compactQueueConsumer04 = new QueueConsumer(compactQueueService, orchestratorService, cab04);

    Cab cab05 = Cab.builder().regNum("AAA").type(CabType.SEDAN).build();
    Cab cab06 = Cab.builder().regNum("BBB").type(CabType.SEDAN).build();
    Cab cab07 = Cab.builder().regNum("CCC").type(CabType.SEDAN).build();
    Cab cab08 = Cab.builder().regNum("DDD").type(CabType.SEDAN).build();

    QueueConsumer sedanQueueConsumer01 = new QueueConsumer(sedanQueueService, orchestratorService, cab05);
    QueueConsumer sedanQueueConsumer02 = new QueueConsumer(sedanQueueService, orchestratorService, cab06);
    QueueConsumer sedanQueueConsumer03 = new QueueConsumer(sedanQueueService, orchestratorService, cab07);
    QueueConsumer sedanQueueConsumer04 = new QueueConsumer(sedanQueueService, orchestratorService, cab08);


    QueueProducer compactQueueProducer = new QueueProducer(compactQueueService, CabType.COMPACT);
    QueueProducer sedanQueueProducer = new QueueProducer(sedanQueueService, CabType.SEDAN);

    ExecutorService executorService = Executors.newFixedThreadPool(20);


    executorService.submit(
        () -> {
          compactQueueProducer.run();
        }
    );

    executorService.submit(
        () -> {
          sedanQueueProducer.run();
        }
    );

    executorService.submit(
        () -> {
          compactQueueConsumer01.run();
        }
    );

    executorService.submit(
        () -> {
          compactQueueConsumer02.run();
        }
    );

    executorService.submit(
        () -> {
          compactQueueConsumer03.run();
        }
    );


    executorService.submit(
        () -> {
          sedanQueueConsumer03.run();
        }
    );
    executorService.submit(
        () -> {
          sedanQueueConsumer03.run();
        }
    );
    executorService.submit(
        () -> {
          sedanQueueConsumer03.run();
        }
    );
  }
}
