package com.example.demo.service;

import com.example.demo.entity.SearchQueryRecord;

import java.util.List;

public interface SearchQueryService {

    SearchQueryRecord saveQuery(SearchQueryRecord record);

    List<SearchQueryRecord> getAllQueries();
}
