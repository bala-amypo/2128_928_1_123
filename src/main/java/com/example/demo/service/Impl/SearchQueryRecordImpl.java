package com.example.demo.service.impl;

import com.example.demo.entity.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepo;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryRecordImpl implements SearchQueryService {

    private final SearchQueryRecordRepo searchQueryRecordRepo;

    public SearchQueryRecordImpl(SearchQueryRecordRepo searchQueryRecordRepo) {
        this.searchQueryRecordRepo = searchQueryRecordRepo;
    }

    @Override
    public SearchQueryRecord createQuery(SearchQueryRecord record) {
        return searchQueryRecordRepo.save(record);
    }

    @Override
    public SearchQueryRecord getQueryById(Long id) {
       SearchQueryRecord record = searchQueryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("SearchQuery not found with id: " + id));
       searchQueryRepository.delete(record);

    }

    @Override
    public List<SearchQueryRecord> getAllQueries() {
        return searchQueryRecordRepo.findAll();
    }

    @Override
    public void deleteQuery(Long id) {
        searchQueryRecordRepo.deleteById(id);
    }
}
