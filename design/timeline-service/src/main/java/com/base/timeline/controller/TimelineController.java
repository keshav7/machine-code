package com.base.timeline.controller;

import com.base.timeline.dto.request.TimelineRequest;
import com.base.timeline.model.Post;
import com.base.timeline.service.api.OrchService;
import com.base.timeline.service.api.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timeline")
public class TimelineController {

  @Autowired
  TimelineService timelineService;

  @Autowired
  OrchService orchService;

  @PostMapping("/get")
  public List<Post> getTimeline(@RequestBody TimelineRequest request) {

    return orchService.getTimeline(request);
  }




}
