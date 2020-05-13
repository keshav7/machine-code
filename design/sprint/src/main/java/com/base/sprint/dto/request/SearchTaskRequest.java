package com.base.sprint.dto.request;

import com.base.sprint.model.TaskStatus;
import lombok.Data;

@Data
public class SearchTaskRequest {
  String sprintId;
  String taskId;
  TaskStatus status;
  String userId;
}
