package com.ronaldocutrim.taskmanager.controller;

import com.ronaldocutrim.taskmanager.infra.entities.Task;
import com.ronaldocutrim.taskmanager.infra.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("task")
public class TaskController {
    TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    List<TaskOutput> task() {
        var tasksList = this.taskRepository.findAll();
        if(tasksList.isEmpty()) return Collections.emptyList();
        return tasksList.stream().map(TaskOutput::new).toList();
    }

    @PostMapping
    ResponseEntity saveTask(@RequestBody TaskInput data) {
        var task = new Task(data);
        this.taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
