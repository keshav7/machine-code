package com.base.sprint.dto.request;

import com.base.sprint.model.TaskStatus;
import lombok.Data;

@Data
public class UpdateTaskRequest {
  String sprintId;
  String taskId;
  String name;
  String userName;
  TaskStatus status;
}
