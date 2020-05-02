package com.base.splitwise.service;

import com.base.splitwise.model.User;
import com.base.splitwise.service.api.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  Map<String, User> userMap = new HashMap<>();

  @Override
  public User addUser(String name) {
    User user = new User();
    user.setId(UUID.randomUUID().toString());
    user.setName(name);
    userMap.put(user.getId(), user);
    return user;
  }

  @Override
  public User getUser(String id) {
    return userMap.get(id);
  }
}
