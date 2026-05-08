package com.example.todoapi.repository.task;

import org.apache.ibatis.annotations.*;

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

    @Update("update tasks set title = #{title} where id = #{id}")
    void update(TaskRecord taskRecord);

    @Delete("delete from tasks where id = #{id}")
    void delete(Long taskId);
}
