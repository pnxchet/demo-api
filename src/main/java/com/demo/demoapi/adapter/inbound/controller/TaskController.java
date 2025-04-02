package com.demo.demoapi.adapter.inbound.controller;

import com.demo.demoapi.adapter.inbound.communication.CommonResponse;
import com.demo.demoapi.adapter.inbound.communication.taskRequest.CreateTaskRequest;
import com.demo.demoapi.adapter.inbound.communication.taskRequest.UpdateStatusRequest;
import com.demo.demoapi.application.gateway.TaskGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskGateway taskGateway;

    @GetMapping()
    public CommonResponse getTasks() {
        return taskGateway.getTasks();
    }

    @PostMapping("/create")
    public CommonResponse createTask(
            @RequestBody CreateTaskRequest request
    ) {
        return taskGateway.createTask(request);
    }

    @PutMapping("/{taskId}/status")
    public CommonResponse updateTaskStatus(
            @PathVariable String taskId,
            @RequestBody UpdateStatusRequest request
            ) {
        return taskGateway.updateTaskStatus(taskId, request);
    }

    @DeleteMapping("/{taskId}")
    public CommonResponse deleteTask(
            @PathVariable String taskId
    ) {
        return taskGateway.deleteTask(taskId);
    }
}
