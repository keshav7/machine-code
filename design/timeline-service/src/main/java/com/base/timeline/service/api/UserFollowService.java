package com.base.timeline.service.api;

import com.base.timeline.model.UserFollow;

import java.util.List;

public interface UserFollowService {

  UserFollow addUserFollow(String followerName, String followeeName);
  List<UserFollow> getUserFollowers(String followerName);

}
