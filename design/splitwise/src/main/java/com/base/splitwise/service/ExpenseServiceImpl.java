package com.base.splitwise.service;

import com.base.splitwise.model.Expense;
import com.base.splitwise.model.enums.SplitType;
import com.base.splitwise.service.api.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ExpenseServiceImpl implements ExpenseService {

  Map<String, Expense> expenseMap = new HashMap<>();

  @Override
  public Expense addExpense(String transaction) {
    Expense expense = fromDto(transaction);
    expenseMap.put(expense.getId(), expense);
    return expense;
  }

  @Override
  public Expense getExpense(String id) {
    return expenseMap.get(id);
  }

  @Override
  public Map<String, Expense> getAllExpenses() {
    return expenseMap;
  }

  private Expense fromDto(String transaction) {

    List<String> list = Arrays.asList(transaction.split("\\s"));
    Expense expense = new Expense();
    expense.setId(UUID.randomUUID().toString());
    expense.setPaid_by(list.get(0));
    expense.setAmount(Integer.valueOf(list.get(1)));
    expense.setMembers(new ArrayList<>());
    int i = 3;
    for (i = 3; i < (3 + Integer.valueOf(list.get(2))); i++) {
      expense.getMembers().add(list.get(i));
    }
    expense.setSplitType(SplitType.fromString(list.get(i)));
    expense.setSplitMap(populateSplitMap(list.subList(i +1, list.size()), expense));

    return expense;
  }


  private Map<String, Double> populateSplitMap(List<String> expenseList, Expense expense) {

    int amount = expense.getAmount();
    List<String> users = expense.getMembers();
    Map<String, Double> splitMap = new HashMap<>();
    switch (expense.getSplitType()) {
      case EQUAL:
        for (String user : users) {
          splitMap.put(user, Double.valueOf(Math.floorDiv(amount, users.size())));
        }
        break;
      case EXACT:
        for (int i = 0; i < users.size(); i++) {
          splitMap.put(users.get(i), Double.valueOf(expenseList.get(i)));
        }
        break;
      case PERCENT:
        for (int i = 0; i < users.size(); i++) {
          splitMap.put(users.get(i), Double.valueOf(((Integer.valueOf(expenseList.get(i))) * amount)/100));
        }
        break;
    }
    return splitMap;
  }
}
