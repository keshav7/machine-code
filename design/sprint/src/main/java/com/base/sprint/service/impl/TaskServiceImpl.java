package com.base.sprint.service.impl;

import com.base.sprint.dto.request.SearchTaskRequest;
import com.base.sprint.dto.request.UpdateTaskRequest;
import com.base.sprint.model.Task;
import com.base.sprint.model.TaskStatus;
import com.base.sprint.model.TaskType;
import com.base.sprint.service.api.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

  List<Task> taskList = new ArrayList<>();

  @Override
  public Task addTask(String name, String sprintId, String userName, TaskType taskType) {

    Task task = Task.builder()
        .id(UUID.randomUUID().toString())
        .name(name)
        .taskType(taskType)
        .sprintId(sprintId)
        .userName(userName)
        .status(TaskStatus.TODO)
        .build();

    taskList.add(task);
    return task;

  }

  @Override
  public Task updateTask(UpdateTaskRequest updateTaskRequest) {
    Task task = null;
    for (Task entry : taskList) {
      if (entry.getSprintId().equals(updateTaskRequest.getSprintId()) &&
      entry.getId().equals(updateTaskRequest.getTaskId())) {

        task = entry;
        break;
      }
    }
    if (task != null) {
      if (updateTaskRequest.getStatus() != null) {
        task.setStatus(updateTaskRequest.getStatus());
      }
      if (updateTaskRequest.getUserName() != null) {
        task.setUserName(updateTaskRequest.getUserName());
      }
      if (updateTaskRequest.getName() != null) {
        task.setName(updateTaskRequest.getName());
      }
    }
    
    return task;
  }


  @Override
  public List<Task> searchTasks(SearchTaskRequest request) {
    List<Task> result = new ArrayList<>();

    for (Task task :  taskList) {
      if (
          (request.getSprintId() != null && task.getSprintId().equals(request.getSprintId())) ||
              (request.getTaskId() != null && task.getId().equals(request.getTaskId())) ||
              (request.getStatus() != null && task.getStatus().equals(request.getStatus())) ||
              (request.getUserId() != null && task.getUserName().equals(request.getUserId()))) {
        result.add(task);
      }
    }
    return result;
  }
}
