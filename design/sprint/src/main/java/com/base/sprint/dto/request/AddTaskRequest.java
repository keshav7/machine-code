package com.base.sprint.dto.request;

import com.base.sprint.model.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskRequest {

  String name;
  String sprintId;
  String userName;
  TaskType taskType;
}
