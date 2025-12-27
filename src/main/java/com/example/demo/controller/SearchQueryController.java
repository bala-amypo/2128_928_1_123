package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;   // ✅ REQUIRED IMPORT

@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    @PostMapping("/employees")
    public Object searchEmployees(
            @org.springframework.web.bind.annotation.RequestBody List<Long> skillIds) {
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
