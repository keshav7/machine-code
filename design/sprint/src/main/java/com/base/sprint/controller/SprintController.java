package com.base.sprint.controller;

import com.base.sprint.model.Sprint;
import com.base.sprint.service.api.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sprint")
public class SprintController {

  @Autowired
  SprintService sprintService;


  @PostMapping("/add")
  Sprint addSprint(@RequestBody String name) {
    return sprintService.addSprint(name);

  }



}
