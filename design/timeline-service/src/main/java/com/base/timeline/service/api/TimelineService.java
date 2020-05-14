package com.base.timeline.service.api;

import com.base.timeline.model.TimeLine;

import java.util.List;

public interface TimelineService {

  void addPostToTimeline(String postId, String userId);

  List<String> getUserTimeline(String userId);

}
