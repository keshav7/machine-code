package com.base.splitwise.service;

import com.base.splitwise.model.BalanceReport;
import com.base.splitwise.model.Expense;
import com.base.splitwise.model.User;
import com.base.splitwise.service.api.BalanceReportService;
import com.base.splitwise.service.api.ExpenseService;
import com.base.splitwise.service.api.SplitwiseManagerService;
import com.base.splitwise.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseBalanceServiceImp implements SplitwiseManagerService {

  @Autowired
  UserService userService;

  @Autowired
  ExpenseService expenseService;

  @Autowired
  BalanceReportService balanceReportService;

  @Override
  public Expense addExpense(String transaction) {

    Expense expense = expenseService.addExpense(transaction);
    Map<String, Double> userPayMap = new HashMap<>();
    balanceReportService.createBalanceReport(expense.getPaid_by(), getCreditorMap(expense.getPaid_by(), expense.getSplitMap()));

    return expense;  // TODO impl
  }

  private Map<String, Double> getCreditorMap(String userId, Map<String, Double> userMap) {
    Map<String, Double> creditorMap = new HashMap<>();
    for (Map.Entry<String, Double> entry : userMap.entrySet()) {
      if (!userId.equals(entry.getKey())) {
        creditorMap.put(entry.getKey(), entry.getValue());
      }
    }
    return creditorMap;
  }

  @Override
  public List<String> showAllBalances() {

    Map<String, BalanceReport> balanceReportMap = balanceReportService.getBalanceReportMap();

    List<String> balances = new ArrayList<>();
    for (Map.Entry<String, BalanceReport> entry : balanceReportMap.entrySet()) {
      Map<String, Double> creditorMap = entry.getValue().getUserMap();
      for (Map.Entry<String, Double> creditEntry : creditorMap.entrySet())
      balances.add(creditEntry.getKey() + "owes" + entry.getValue().getUser() + "\\s" + creditEntry.getValue());
    }


    return balances;
  }

  @Override
  public List<String> showUserBalances() {
    return null;  // TODO impl
  }


  @Override
  public User addUser(String name) {
    return userService.addUser(name);
  }

  @Override
  public User getUser(String user) {
    return userService.getUser(user);
  }
}
