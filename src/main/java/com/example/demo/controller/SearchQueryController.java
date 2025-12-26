package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    @PostMapping("/employees")
    public Object searchEmployees(@RequestBody Object body) {
        return null;
    }

    @GetMapping("/{id}")
    public Object getQuery(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/user/{userId}")
    public Object getQueriesByUser(@PathVariable Long userId) {
        return null;
    }
}
