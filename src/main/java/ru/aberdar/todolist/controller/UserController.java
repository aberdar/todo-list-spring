package ru.aberdar.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aberdar.todolist.entity.UserEntity;
import ru.aberdar.todolist.exception.UserAlreadyExistsException;
import ru.aberdar.todolist.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User saved");
        } catch (UserAlreadyExistsException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Error when user saving");
        }
    }

    @GetMapping("/")
    public ResponseEntity<String> getUsers() {
        try {
            return ResponseEntity.ok("Server is ready");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
