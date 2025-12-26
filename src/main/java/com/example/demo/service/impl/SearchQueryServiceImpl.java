package com.example.demo.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

private final SearchQueryRecordRepository repository;

public SearchQueryServiceImpl(SearchQueryRecordRepository repository) {
this.repository = repository;
}

@Override
public SearchQueryRecord saveQuery(String query) {
SearchQueryRecord record = new SearchQueryRecord();
record.setQuery(query);
record.setTimestamp(LocalDateTime.now());
return repository.save(record);
}
}
