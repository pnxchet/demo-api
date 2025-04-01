package com.demo.demoapi.adapter.inbound.controller;

import com.demo.demoapi.adapter.outbound.persistence.taskPersistence.TaskPersistenceObject;
import com.demo.demoapi.application.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public List<TaskPersistenceObject> getTasks() {
        return taskService.getTasks();
    }
}
