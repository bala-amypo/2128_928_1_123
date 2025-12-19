package com.example.demo.controller;

import com.example.demo.entity.SearchQueryRecord;
import com.example.demo.service.impl.SearchQueryRecordImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search-queries")
public class SearchQueryController {

@Autowired
private SearchQueryRecordImpl service;

@PostMapping
public SearchQueryRecord createQuery(@Valid @RequestBody SearchQueryRecord record) {
return service.create(record);
}

@GetMapping("/{id}")
public SearchQueryRecord getQuery(@PathVariable Long id) {
return service.getById(id);
}

@DeleteMapping("/{id}")
public void deleteQuery(@PathVariable Long id) {
service.delete(id);
}
}
