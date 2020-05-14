package com.base.timeline.service.impl;

import com.base.timeline.model.TimeLine;
import com.base.timeline.service.api.TimelineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class TimelineServiceImpl implements TimelineService {

  Map<String, LinkedList<String>> timelines = new HashMap<>();

  @Override
  public void addPostToTimeline(String postId, String userId) {

    if (!timelines.containsKey(userId) || timelines.get(userId).isEmpty()) {
      timelines.put(userId, new LinkedList<>());
    }
    List<String> timelinePosts = timelines.get(userId);
    timelinePosts.add(0, postId);
  }

  @Override
  public List<String> getUserTimeline(String userId) {
    return timelines.get(userId);
  }
}
