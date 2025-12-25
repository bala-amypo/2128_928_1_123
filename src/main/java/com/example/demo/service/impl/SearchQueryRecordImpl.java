package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SearchQueryRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SearchQueryRecordRepo;
import com.example.demo.service.SearchQueryService;

@Service
public class SearchQueryRecordImpl implements SearchQueryService {

    private final SearchQueryRecordRepo searchQueryRepo;

    public SearchQueryRecordImpl(SearchQueryRecordRepo searchQueryRepo) {
        this.searchQueryRepo = searchQueryRepo;
    }

    @Override
    public SearchQueryRecord create(SearchQueryRecord record) {
        return searchQueryRepo.save(record);
    }

    @Override
    public SearchQueryRecord getById(Long id) {
        return searchQueryRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Search query not found with id: " + id));
    }

    @Override
    public List<SearchQueryRecord> getAll() {
        return searchQueryRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        searchQueryRepo.delete(getById(id));
    }
}
