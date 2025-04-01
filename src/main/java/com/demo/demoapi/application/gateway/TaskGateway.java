package com.demo.demoapi.application.gateway;

import com.demo.demoapi.adapter.outbound.persistence.taskPersistence.TaskPersistenceObject;

import java.util.List;

public interface TaskGateway {
    public List<TaskPersistenceObject> getTasks();
}
