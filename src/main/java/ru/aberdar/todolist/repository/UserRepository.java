package ru.aberdar.todolist.repository;

import org.springframework.data.repository.CrudRepository;
import ru.aberdar.todolist.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
