package com.example.todoapi.repository.task;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskRepository {

    @Select("Select id, title From tasks where id = #{taskId} ")
    Optional<TaskRecord> select(long taskId);

    @Select("select id, title from tasks LIMIT #{limit} OFFSET #{offset}")
    List<TaskRecord> selectList(int limit, long offset);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("Insert into tasks (title) values (#{title})")
    void insert(TaskRecord record);


}
