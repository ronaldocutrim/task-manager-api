package com.ronaldocutrim.taskmanager.infra.entities;

import com.ronaldocutrim.taskmanager.controller.TaskInput;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.cglib.core.Local;


import java.time.LocalDateTime;

@Entity(name="tasks")
@Table(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getExpire_in() {
        return expire_in;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime expire_in;

    @Column(updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TaskPriority priority;

    public Task(TaskInput input) {
        this.title = input.title();
        this.description = input.description();
        this.expire_in = LocalDateTime.parse(input.expire_in());
        this.priority = TaskPriority.fromValue(input.priority());
        this.status = TaskStatus.valueOf(input.status());
    }

    public Task() {}

}
