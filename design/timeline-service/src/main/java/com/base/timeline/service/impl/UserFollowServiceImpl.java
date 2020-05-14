package com.base.timeline.service.impl;

import com.base.timeline.model.UserFollow;
import com.base.timeline.service.api.UserFollowService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;

@Service
public class UserFollowServiceImpl implements UserFollowService {

  List<UserFollow> userFollowList = new ArrayList<>();

  @PostConstruct
  public void initialise() {
    Random random = new Random();
    for (int i = 0; i <  200; i++) {
      for (int j = 0 ; j < 20; j++) {

        int k = random.nextInt(200);
        if (k != i) {
          this.addUserFollow("U" + i, "U" + k);
        }
      }
    }
  }

  @Override
  public UserFollow addUserFollow(String followerName, String followeeName) {
    UserFollow userFollow = UserFollow.builder().followeeId(followeeName).followerId(followerName).build();
    userFollowList.add(userFollow);
    return userFollow;

  }

  @Override
  public List<UserFollow> getUserFollowers(String followerName) {
    List<UserFollow> userFollowList1 = new ArrayList<>();

    for (UserFollow userFollow : userFollowList) {
      if (userFollow.getFollowerId().equals(followerName)) {
        userFollowList1.add(userFollow);
      }
    }

    return userFollowList1;
  }
}