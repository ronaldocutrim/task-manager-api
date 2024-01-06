package com.ronaldocutrim.taskmanager.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class RequestsExceptionHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity threatNotFound() {
        return ResponseEntity.notFound().build();
    }
}
