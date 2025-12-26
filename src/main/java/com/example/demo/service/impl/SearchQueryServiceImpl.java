package com.example.demo.service.impl;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

private final SearchQueryRecordRepository repository;

public SearchQueryServiceImpl(SearchQueryRecordRepository repository) {
this.repository = repository;
}

@Override
public SearchQueryRecord saveQuery(SearchQueryRecord record) {
record.setTimestamp(LocalDateTime.now());
return repository.save(record);
}

@Override
public List<SearchQueryRecord> getAllQueries() {
return repository.findAll();
}
}
