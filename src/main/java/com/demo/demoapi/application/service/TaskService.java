package com.demo.demoapi.application.service;

import com.demo.demoapi.adapter.inbound.communication.CommonResponse;
import com.demo.demoapi.adapter.inbound.communication.taskRequest.CreateTaskRequest;
import com.demo.demoapi.adapter.inbound.communication.taskRequest.UpdateStatusRequest;
import com.demo.demoapi.adapter.outbound.persistence.taskPersistence.TaskPersistenceObject;
import com.demo.demoapi.adapter.outbound.persistence.taskPersistence.TaskRepository;
import com.demo.demoapi.application.exception.BadRequestException;
import com.demo.demoapi.application.gateway.TaskGateway;
import com.demo.demoapi.util.Constant;
import com.demo.demoapi.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService implements TaskGateway {
    @Autowired
    private TaskRepository taskReposistory;

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

    public CommonResponse updateTaskStatus(String taskId, UpdateStatusRequest request) {
        UUID taskUUID = ConvertUtil.convertStringToUUID(taskId);
        Boolean isCompleted = request.getStatus();
        if (isCompleted == null) {
            throw new BadRequestException("Status not null");
        }
        LocalDateTime completedAt = isCompleted ? LocalDateTime.now() : null;

        taskReposistory.updateTaskStatus(taskUUID, isCompleted, completedAt);
        return new CommonResponse(HttpStatus.OK.value(), Constant.SUCCESS, null);
    }

    public CommonResponse deleteTask(String taskId) {
        UUID taskUUID = ConvertUtil.convertStringToUUID(taskId);
        taskReposistory.deleteTask(taskUUID);
        return new CommonResponse(HttpStatus.OK.value(), Constant.SUCCESS, null);
    }
}
