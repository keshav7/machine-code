package com.base.timeline.service.api;

import com.base.timeline.dto.PostRequest;
import com.base.timeline.dto.request.TimelineRequest;
import com.base.timeline.model.Post;

import java.util.List;

public interface OrchService {

  void updateTimeline(PostRequest request);

  List<Post> getTimeline(TimelineRequest request);

}
