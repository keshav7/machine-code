package com.base.splitwise.model;


import com.base.splitwise.model.enums.SplitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

  private String id;
  private SplitType splitType;
  private Integer amount;
  private String paid_by;
  List<String> members;
  Map<String, Double> splitMap;

}
