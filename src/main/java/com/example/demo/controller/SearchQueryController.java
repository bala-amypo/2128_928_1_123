package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/search")
@CrossOrigin
public class SearchQueryController {

    @PostMapping("/employees")
    public Object searchEmployees(@RequestBody List<Long> skillIds) {
        return skillIds;
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
