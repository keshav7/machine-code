package com.base.sprint.service.api;

import com.base.sprint.dto.request.SearchTaskRequest;
import com.base.sprint.dto.request.UpdateTaskRequest;
import com.base.sprint.model.Task;
import com.base.sprint.model.TaskType;

import java.util.List;

public interface TaskService {

  Task addTask(String name, String sprintId, String userName, TaskType taskType);

  Task updateTask(UpdateTaskRequest updateTaskRequest);

  List<Task> searchTasks(SearchTaskRequest request);
}
