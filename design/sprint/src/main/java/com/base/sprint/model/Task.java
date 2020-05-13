package com.base.sprint.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {

  String id;
  String sprintId;
  String name;
  String userName;
  TaskType taskType;
  TaskStatus status;

}
