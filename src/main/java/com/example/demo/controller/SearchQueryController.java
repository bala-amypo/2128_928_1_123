package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    @PostMapping("/employees")
    public Object searchEmployees(@RequestBody List<Long> skills) {
        return null;
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/user/{userId}")
    public Object getByUser(@PathVariable Long userId) {
        return null;
    }
}
