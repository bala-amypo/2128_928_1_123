package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;

@RestController
@RequestMapping("/search-queries")
public class SearchQueryController {

    private final SearchQueryService searchQueryService;

    public SearchQueryController(SearchQueryService searchQueryService) {
        this.searchQueryService = searchQueryService;
    }

    @PostMapping
    public SearchQueryRecord create(@Valid @RequestBody SearchQueryRecord record) {
        return searchQueryService.create(record);
    }

    @GetMapping("/{id}")
    public SearchQueryRecord getById(@PathVariable Long id) {
        return searchQueryService.getById(id);
    }

    @GetMapping
    public List<SearchQueryRecord> getAll() {
        return searchQueryService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        searchQueryService.delete(id);
    }
}
