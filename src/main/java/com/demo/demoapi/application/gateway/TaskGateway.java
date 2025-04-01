package com.demo.demoapi.application.gateway;

import com.demo.demoapi.adapter.inbound.communication.CommonResponse;
import com.demo.demoapi.adapter.inbound.communication.taskRequest.CreateTaskRequest;
import com.demo.demoapi.adapter.outbound.persistence.taskPersistence.TaskPersistenceObject;

import java.util.List;

public interface TaskGateway {
    public CommonResponse getTasks();

    public CommonResponse createTask(CreateTaskRequest request);
}
