package com.example.todoapi.controller.task;

import com.example.todo_api.model.TaskDTO;
import com.example.todoapi.controller.TasksApi;
import com.example.todoapi.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TasksController implements TasksApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<TaskDTO> showTask(Long taskId){
        var entity = taskService.find(taskId);
        var dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<TaskDTO> createTask(com.example.todo_api.model.CreateTaskRequest createTaskRequest){        var dto = new TaskDTO();
        var dto = new TaskDTO();
        dto.setId(99L);
        dto.setTitle("created!");
        return ResponseEntity.
                status(HttpStatus.CREATED).
                build(dto);
    }

}
