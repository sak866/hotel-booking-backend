package com.example.hotelbooking_app.Controller;

import com.example.hotelbooking_app.entity.User;
import com.example.hotelbooking_app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")

    public ResponseEntity<?> login(@RequestBody User user) {

    Optional<User> loginUser =

    userService.loginUser(user.getEmail(), user.getPassword());



    if (loginUser.isPresent()) {

    return ResponseEntity.ok(loginUser.get());

    }



    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)

    .body("Invalid email or password");

    } 


   }

