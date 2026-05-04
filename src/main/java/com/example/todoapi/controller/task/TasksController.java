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
    public ResponseEntity<Void> createTask(com.example.todo_api.model.CreateTaskRequest createTaskRequest){
        // 受け取った createTaskRequest を使ってサービスを呼び出す処理などをここに書く
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
