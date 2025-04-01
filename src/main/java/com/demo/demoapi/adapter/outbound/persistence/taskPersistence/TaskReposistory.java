package com.demo.demoapi.adapter.outbound.persistence.taskPersistence;

import com.demo.demoapi.application.exception.DatabaseErrorException;
import com.demo.demoapi.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskReposistory {
    private final TaskJpaReposistory taskJpaReposistory;
    private static final Logger Logger = LoggerFactory.getLogger(TaskReposistory.class);

    public TaskReposistory(TaskJpaReposistory taskJpaReposistory) {
        this.taskJpaReposistory = taskJpaReposistory;
    }

    public List<TaskPersistenceObject> getTasks() {
        try {
            return taskJpaReposistory.findAll();
        } catch (Exception e) {
            Logger.error(Constant.DATABASE_ERROR, e);
            throw new DatabaseErrorException(Constant.DATABASE_ERROR);
        }
    }

    public void createTask(TaskPersistenceObject task) {
        try {
            taskJpaReposistory.save(task);
        } catch (Exception e) {
            Logger.error(Constant.DATABASE_ERROR, e);
            throw new DatabaseErrorException(Constant.DATABASE_ERROR);
        }
    }
}
