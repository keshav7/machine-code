package com.base.splitwise.service.api;

import com.base.splitwise.model.User;

public interface UserService {

  User addUser(String name);
  User getUser(String id);

}
