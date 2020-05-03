package com.base.dream11.service.api;

import com.base.dream11.model.Team;

import java.util.List;

public interface TeamService {

  Team addTeam(String input);
  List<Team> getTeams();
}
