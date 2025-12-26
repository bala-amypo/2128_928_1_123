package com.example.demo.controller;

import com.example.demo.model.SearchQuery;
import com.example.demo.service.SearchQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@Tag(name = "Search Query Controller")
public class SearchQueryController {

    @Autowired
    private SearchQueryService searchQueryService;

    @PostMapping("/employees")
    public List<?> searchEmployees(@RequestBody List<Long> skillIds) {
        return searchQueryService.searchEmployees(skillIds);
    }

    @GetMapping("/{id}")
    public SearchQuery getById(@PathVariable Long id) {
        return searchQueryService.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<SearchQuery> getByUser(@PathVariable Long userId) {
        return searchQueryService.getByUser(userId);
    }
}
