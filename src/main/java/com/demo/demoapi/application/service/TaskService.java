package com.demo.demoapi.application.service;

import com.demo.demoapi.adapter.outbound.persistence.taskPersistence.TaskPersistenceObject;
import com.demo.demoapi.adapter.outbound.persistence.taskPersistence.TaskReposistory;
import com.demo.demoapi.application.gateway.TaskGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements TaskGateway {
    private final TaskReposistory taskReposistory;

    public TaskService(TaskReposistory taskReposistory) {
        this.taskReposistory = taskReposistory;
    }

    public List<TaskPersistenceObject> getTasks() {
        return taskReposistory.getTasks();
    }
}
