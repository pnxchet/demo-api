package com.demo.demoapi.adapter.inbound.controller;

import com.demo.demoapi.adapter.inbound.communication.CommonResponse;
import com.demo.demoapi.adapter.inbound.communication.taskRequest.CreateTaskRequest;
import com.demo.demoapi.application.gateway.TaskGateway;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskGateway taskGateway;

    public TaskController(TaskGateway taskGateway) {
        this.taskGateway = taskGateway;
    }

    @GetMapping()
    public CommonResponse getTasks() {
        return taskGateway.getTasks();
    }

    @PostMapping()
    public CommonResponse createTask(
            @RequestBody CreateTaskRequest request
    ) {
        return taskGateway.createTask(request);
    }
}
