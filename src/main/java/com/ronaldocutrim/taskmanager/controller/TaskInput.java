package com.ronaldocutrim.taskmanager.controller;

import java.time.LocalDateTime;

public record TaskInput(String title, String description, String expire_in, Number priority, String status) {
}
