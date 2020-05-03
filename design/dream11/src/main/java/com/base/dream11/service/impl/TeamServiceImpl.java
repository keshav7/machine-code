package com.base.dream11.service.impl;

import com.base.dream11.model.Team;
import com.base.dream11.service.api.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class TeamServiceImpl implements TeamService {

  List<Team> teams = new ArrayList<>();


  @Override
  public Team addTeam(String input) {

    List<String> list = Arrays.asList(input.split("\\s"));

    Team team = new Team();
    team.setUser(list.get(0));
    team.setPlayers(Arrays.asList(list.get(1).split("\\s")));

    team.setId(UUID.randomUUID().toString());

    teams.add(team);

    return team;
  }

  @Override
  public List<Team> getTeams() {
    return teams;
  }
}
