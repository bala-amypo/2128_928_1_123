package com.example.demo.controller;

import com.example.demo.entity.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search-queries")
public class SearchQueryController {

    private final SearchQueryService searchQueryService;

    public SearchQueryRecordController(SearchQueryService searchQueryService) {
        this.searchQueryService = searchQueryService;
    }

    @PostMapping
    public SearchQueryRecord createQuery(@RequestBody SearchQueryRecord record) {
        return searchQueryService.createQuery(record);
    }

    @GetMapping("/{id}")
    public SearchQueryRecord getQuery(@PathVariable Long id) {
        return searchQueryService.getQueryById(id);
    }

    @GetMapping
    public List<SearchQueryRecord> getAllQueries() {
        return searchQueryService.getAllQueries();
    }

    @DeleteMapping("/{id}")
    public void deleteQuery(@PathVariable Long id) {
        searchQueryService.deleteQuery(id);
    }
}
