package com.example.demo.controller;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
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
    public SearchQueryRecord save(@RequestBody String query) {
        return service.saveQuery(query);
    }

    @GetMapping
    public List<SearchQueryRecord> getAll() {
        return service.getAllQueries();
    }
}
