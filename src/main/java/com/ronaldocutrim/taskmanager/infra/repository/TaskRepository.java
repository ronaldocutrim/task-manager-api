package com.ronaldocutrim.taskmanager.infra.repository;

import com.ronaldocutrim.taskmanager.infra.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {
}
