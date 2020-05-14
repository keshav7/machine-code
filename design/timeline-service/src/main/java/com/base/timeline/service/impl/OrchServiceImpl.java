package com.base.timeline.service.impl;

import com.base.timeline.dto.PostRequest;
import com.base.timeline.dto.request.TimelineRequest;
import com.base.timeline.model.Post;
import com.base.timeline.model.UserFollow;
import com.base.timeline.service.api.OrchService;
import com.base.timeline.service.api.PostService;
import com.base.timeline.service.api.TimelineService;
import com.base.timeline.service.api.UserFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrchServiceImpl implements OrchService {

  @Autowired
  PostService postService;

  @Autowired
  TimelineService timelineService;

  @Autowired
  UserFollowService userFollowService;

  @Override
  public void updateTimeline(PostRequest request) {
    Post post = postService.addPost(request.getPost(), request.getUserId());
    List<UserFollow> userFollowList = userFollowService.getUserFollowers(request.getUserId());
    for (UserFollow userFollow : userFollowList) {
      timelineService.addPostToTimeline(post.getId(), userFollow.getFolloweeId());
      System.out.println("Updated timeline for :" + userFollow.getFolloweeId());
    }
  }

  @Override
  public List<Post> getTimeline(TimelineRequest request) {
    List<String> postIds = timelineService.getUserTimeline(request.getUserId());

    List<Post> posts = postService.getPostsByIds(postIds);

    return posts;

  }
}