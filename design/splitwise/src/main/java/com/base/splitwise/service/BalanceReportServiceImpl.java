package com.base.splitwise.service;

import com.base.splitwise.model.BalanceReport;
import com.base.splitwise.service.api.BalanceReportService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BalanceReportServiceImpl implements BalanceReportService {


  Map<String, BalanceReport> balanceReportMap = new HashMap<>();


  @Override
  public BalanceReport createBalanceReport(String userId, Map<String, Double> userMap) {

    BalanceReport balanceReport = new BalanceReport();
    balanceReport.setAmount(getTotalAmount(userMap));
    balanceReport.setUserMap(userMap);

    balanceReportMap.put(userId, balanceReport);
    return balanceReport;
  }

  private Double getTotalAmount(Map<String, Double> userMap) {
    Double totalAmount = 0D;
    for (Map.Entry<String, Double> entry : userMap.entrySet()) {
      totalAmount += entry.getValue();
    }

    return totalAmount;
  }

  @Override
  public BalanceReport getBalanceReport(String id) {
    return balanceReportMap.get(id);
  }

  @Override
  public BalanceReport updateReport(String id, Map<String, Double> userMap) {
    BalanceReport balanceReport = balanceReportMap.get(id);
    Map<String, Double> existingUserMap = balanceReport.getUserMap();
    balanceReport.setAmount(balanceReport.getAmount() + getTotalAmount(userMap));
    for (Map.Entry<String, Double> entry : userMap.entrySet()) {
      if (existingUserMap.containsKey(entry.getKey())) {
        existingUserMap.put(entry.getKey(), existingUserMap.get(entry.getKey()) + entry.getValue());
      } else {
        existingUserMap.put(entry.getKey(), entry.getValue());
      }
    }
    return balanceReport;
  }

  @Override
  public Map<String, BalanceReport> getBalanceReportMap() {
    return balanceReportMap;
  }
}
