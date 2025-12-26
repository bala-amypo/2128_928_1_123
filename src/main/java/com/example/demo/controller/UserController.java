package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

private final UserService service;

public UserController(UserService service) {
this.service = service;
}

@PostMapping
public User create(@RequestBody User user) {
return service.createUser(user);
}

@GetMapping("/{username}")
public User getByUsername(@PathVariable String username) {
return service.findByUsername(username);
}
}
