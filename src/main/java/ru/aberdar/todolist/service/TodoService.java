package ru.aberdar.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aberdar.todolist.entity.TodoEntity;
import ru.aberdar.todolist.entity.UserEntity;
import ru.aberdar.todolist.model.Todo;
import ru.aberdar.todolist.repository.TodoRepository;
import ru.aberdar.todolist.repository.UserRepository;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepository.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo = todoRepository.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepository.save(todo));
    }
}
