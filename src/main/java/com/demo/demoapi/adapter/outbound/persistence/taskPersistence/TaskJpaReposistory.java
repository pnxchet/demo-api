package com.demo.demoapi.adapter.outbound.persistence.taskPersistence;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskJpaReposistory extends JpaRepository<TaskPersistenceObject, UUID> {
}
