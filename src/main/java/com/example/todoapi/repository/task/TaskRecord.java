package com.example.todoapi.repository.task;

import lombok.Value;

@Value
public class TaskRecord {

    Long id; //Longにするとnullが許される
    String title;
}
