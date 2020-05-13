package com.base.sprint.controller;

import com.base.sprint.dto.request.SearchTaskRequest;
import com.base.sprint.dto.request.UpdateTaskRequest;
import com.base.sprint.dto.request.AddTaskRequest;
import com.base.sprint.model.Task;
import com.base.sprint.service.api.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {

  @Autowired
  TaskService taskService;


  @PostMapping("/add")
  Task addTask(@RequestBody AddTaskRequest addTaskRequest) {
    return taskService.addTask(addTaskRequest.getName(), addTaskRequest.getSprintId(),
        addTaskRequest.getUserName(), addTaskRequest.getTaskType());
  }


  @PostMapping("/update")
  Task updateTask(@RequestBody UpdateTaskRequest request) {
    return taskService.updateTask(request);

  }

  @PostMapping("/search")
  List<Task> searchTasks(@RequestBody SearchTaskRequest searchTaskRequest) {

    return taskService.searchTasks(searchTaskRequest);
  }


}
