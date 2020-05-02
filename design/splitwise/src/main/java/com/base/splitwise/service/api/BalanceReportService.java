package com.base.splitwise.service.api;

import com.base.splitwise.model.BalanceReport;

import java.util.Map;

public interface BalanceReportService {

  BalanceReport createBalanceReport(String userId, Map<String, Double> userMap);

  BalanceReport getBalanceReport(String id);

  Map<String, BalanceReport> getBalanceReportMap();

  BalanceReport updateReport(String id, Map<String, Double> userMap);
}
