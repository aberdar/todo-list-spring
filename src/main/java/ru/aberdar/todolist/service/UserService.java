package ru.aberdar.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aberdar.todolist.entity.UserEntity;
import ru.aberdar.todolist.exception.UserAlreadyExistsException;
import ru.aberdar.todolist.exception.UserNotFoundException;
import ru.aberdar.todolist.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistsException("User with this name already exists");
        }
        userRepository.save(user);
    }

    public UserEntity getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
}
