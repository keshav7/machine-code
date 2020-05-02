package com.base.splitwise.service.api;

import com.base.splitwise.model.Expense;
import com.base.splitwise.model.User;

import java.util.List;

public interface SplitwiseManagerService {

  User addUser(String name);
  User getUser(String user);
  Expense addExpense(String transaction);
  List<String> showAllBalances();
  List<String> showUserBalances();

}
