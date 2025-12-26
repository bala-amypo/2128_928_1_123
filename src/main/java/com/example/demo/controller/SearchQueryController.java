package com.example.demo.controller;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search-queries")
public class SearchQueryController {

    private final SearchQueryService service;

    public SearchQueryController(SearchQueryService service) {
        this.service = service;
    }

    @PostMapping
    public SearchQueryRecord saveQuery(@Valid @RequestBody SearchQueryRecord record) {
        return service.saveQuery(record);
    }

    @GetMapping
    public List<SearchQueryRecord> getAllQueries() {
        return service.getAllQueries();
    }
}
