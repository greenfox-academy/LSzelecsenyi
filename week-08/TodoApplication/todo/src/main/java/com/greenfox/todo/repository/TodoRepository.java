package com.greenfox.todo.repository;

import com.greenfox.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findAllByIsDone(boolean isDone);
    List<Todo> findAllByTitle(String title);
    List<Todo> findAllByTitleIsContaining(String fragment);
    List<Todo> findAllByCreated(LocalDateTime date);
    List<Todo> findAllByDueDate(LocalDateTime date);
    List<Todo> findAllByAssigneeNameIs(String assignee);
    List<Todo> findAllByAssigneeNameContaining(String assignee);

}
