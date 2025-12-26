package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.SearchQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchQueryController {

    private final SearchQueryService searchQueryService;

    public SearchQueryController(SearchQueryService searchQueryService) {
        this.searchQueryService = searchQueryService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> searchEmployeesBySkills(
            @RequestParam List<String> skills) {
        return ResponseEntity.ok(searchQueryService.searchEmployeesBySkills(skills));
    }
}
