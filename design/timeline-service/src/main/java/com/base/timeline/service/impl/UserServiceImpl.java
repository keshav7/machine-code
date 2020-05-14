package com.base.timeline.service.impl;

import com.base.timeline.model.User;
import com.base.timeline.service.api.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

  List<User> userList = new ArrayList<>();

  @PostConstruct
  public void intialise() {
    for (int i = 0 ; i < 200; i++) {
      this.addUser("U" + i);
    }
  }


  @Override
  public User addUser(String name) {
    User user = User.builder().name(name).id(UUID.randomUUID().toString().substring(4, 8)).build();
    userList.add(user);
    return user;
  }
}
