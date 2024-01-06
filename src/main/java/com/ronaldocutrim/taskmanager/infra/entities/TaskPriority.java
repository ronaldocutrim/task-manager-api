package com.ronaldocutrim.taskmanager.infra.entities;

import java.util.Objects;

public enum TaskPriority {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private Number value;
    TaskPriority(Number value) {
        this.value = value;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }

    public static TaskPriority fromValue(Number value) {
        for (TaskPriority priority : TaskPriority.values()) {
            if (Objects.equals(priority.getValue(), value)) {
                System.out.println(priority.getValue());
                return priority;
            }
        }
        throw new IllegalArgumentException("Valor inválido para TaskPriority: " + value);
    }
}
