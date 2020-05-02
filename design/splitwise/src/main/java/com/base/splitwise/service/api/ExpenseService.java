package com.base.splitwise.service.api;

import com.base.splitwise.model.Expense;

import java.util.Map;

public interface ExpenseService {

  Expense addExpense(String transaction);
  Expense getExpense(String id);
  Map<String, Expense> getAllExpenses();
}
