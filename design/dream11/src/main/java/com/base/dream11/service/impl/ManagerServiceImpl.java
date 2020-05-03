package com.base.dream11.service.impl;

import com.base.dream11.service.QueueConsumer;
import com.base.dream11.service.api.EventService;
import com.base.dream11.service.api.ManagerService;
import com.base.dream11.service.api.QueueService;
import com.base.dream11.service.api.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ManagerServiceImpl implements ManagerService {

  @Autowired
  QueueService queueService;

  @Autowired
  TeamService teamService;

  @Autowired
  EventService eventService;

  @Override
  public void initialise() {
    QueueConsumer queueConsumer1 = new QueueConsumer("1", queueService, 1000L, teamService);
    QueueConsumer queueConsumer2 = new QueueConsumer("2", queueService, 1000L, teamService);

    ExecutorService executorService = Executors.newFixedThreadPool(2);


    executorService.submit(
        () -> {
          try {
            queueConsumer1.run();
          } catch(Exception e) {
          }
        }
    );

    executorService.submit(
        () -> {
          try {
            queueConsumer2.run();
          } catch(Exception e) {
          }
        }
    );

    try {
      teamService.addTeam("u1 p1,p2,p3,p4,p5,p6");
      teamService.addTeam("u2 p4,p5,p6,p7,p8");
      teamService.addTeam("u3 p6,p8,p8,p10");
      teamService.addTeam("u4 p10,p11,p12,p9");
      teamService.addTeam("u5 p10,p11,p4,p5,p14");

      eventService.addEvent("CATCH p1");
      eventService.addEvent("CATCH p4");
      eventService.addEvent("CATCH p10");
      eventService.addEvent("CATCH p14");

      eventService.addEvent("WICKET p4");
      eventService.addEvent("WICKET p5");
      eventService.addEvent("WICKET p9");

      eventService.addEvent("RUN p1 2");
      eventService.addEvent("RUN p3 1");
      eventService.addEvent("RUN p5 3");
      eventService.addEvent("RUN p6 1");
      eventService.addEvent("RUN p7 4");

    } catch(Exception e) {

      // handle
    }
  }


}
