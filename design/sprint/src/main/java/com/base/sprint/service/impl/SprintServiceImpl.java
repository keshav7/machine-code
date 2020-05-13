package com.base.sprint.service.impl;

import com.base.sprint.model.Sprint;
import com.base.sprint.service.api.SprintService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SprintServiceImpl implements SprintService {

  List<Sprint> sprintList = new ArrayList<>();

  @Override
  public Sprint addSprint(String name) {
    Sprint sprint = Sprint.builder().id(UUID.randomUUID().toString()).name(name).build();
    sprintList.add(sprint);
    return sprint;
  }
}
