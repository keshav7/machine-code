package com.base.dream11.service;

import com.base.dream11.model.Event;
import com.base.dream11.model.EventType;
import com.base.dream11.model.Team;
import com.base.dream11.service.api.QueueService;
import com.base.dream11.service.api.TeamService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class QueueConsumer {

  String id;
  QueueService queueService;
  Long sleepTime;

  TeamService teamService;


  public static Integer RUN_PONTS = 2;
  public static Integer CATCH_PONTS = 4;
  public static Integer WICKET_PONTS = 8;

  // team service and leaderboard service

  public QueueConsumer(String id, QueueService queueService, Long sleepTime, TeamService teamService) {
    this.id = id;
    this.queueService = queueService;
    this.sleepTime = sleepTime;
    this.teamService = teamService;
  }

  public void run() throws InterruptedException {

    while(true) {
      if (queueService.getEvent() != null) {

        System.out.println("Handling by consumer" + this.getId());
        Event event = queueService.getEvent();
        processEvent(event);
        System.out.println("Handling done" + this.getId());
      } else {
        Thread.sleep(sleepTime);
      }
    }

  }


  private void processEvent(Event event) {

    String player = event.getPlayer();
    EventType eventType = event.getEventType();
    List<Team> teams = teamService.getTeams();
    for (Team team : teams) {
      if (team.getPlayers().contains(player)) {
        team.setPoints(team.getPoints() + getPoints(event));
        System.out.println("team :" + team.getId() + " points :" + team.getPoints());
      }
    }

  }


  private Integer getPoints(Event event) {

    switch (event.getEventType()) {
      case RUN: return (Integer.valueOf(event.getNumber()) * RUN_PONTS);
      case WICKET: return WICKET_PONTS;
      case CATCH:return CATCH_PONTS;
    }
    return 0;
  }

}
