package ru.aberdar.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import ru.aberdar.todolist.entity.TodoEntity;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
