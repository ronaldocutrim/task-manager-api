package com.ronaldocutrim.taskmanager.controller;

import com.ronaldocutrim.taskmanager.infra.entities.Task;

import java.time.LocalDateTime;

public record TaskOutput(String id, String title, String description, LocalDateTime createdAt, LocalDateTime expireIn, Number priority, String status) {
    public TaskOutput(Task task) {
        this(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreated_at(),
                task.getExpire_in(),
                task.getPriority().getValue(),
                task.getStatus().toString()
        );
    }
}
