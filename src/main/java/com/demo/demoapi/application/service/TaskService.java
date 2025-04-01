package com.demo.demoapi.application.service;

import com.demo.demoapi.adapter.inbound.communication.CommonResponse;
import com.demo.demoapi.adapter.inbound.communication.taskRequest.CreateTaskRequest;
import com.demo.demoapi.adapter.outbound.persistence.taskPersistence.TaskPersistenceObject;
import com.demo.demoapi.adapter.outbound.persistence.taskPersistence.TaskReposistory;
import com.demo.demoapi.application.gateway.TaskGateway;
import com.demo.demoapi.util.Constant;
import com.demo.demoapi.util.ConvertUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService implements TaskGateway {
    private final TaskReposistory taskReposistory;

    public TaskService(
            TaskReposistory taskReposistory
    ) {
        this.taskReposistory = taskReposistory;
    }

    public CommonResponse getTasks() {
        List<TaskPersistenceObject> tasks = taskReposistory.getTasks();
        return new CommonResponse(HttpStatus.OK.value(), Constant.SUCCESS, tasks);
    }

    public CommonResponse createTask(CreateTaskRequest request) {
        TaskPersistenceObject task = new TaskPersistenceObject(
                UUID.randomUUID(), // id
                request.getTitle(), // title
                request.getDescription(), // description
                false, // isCompleted
                ConvertUtil.convertStringToLocalDateTime(request.getDueDate()), // dueDate
                null,  // completedAt
                request.getCreatedBy(), // createdBy
                LocalDateTime.now() // createdAt
        );
        taskReposistory.createTask(task);
        return new CommonResponse(HttpStatus.CREATED.value(), Constant.SUCCESS, null);
    }
}
