package com.example.demo.service;

import com.example.demo.model.SearchQueryRecord;

import java.util.List;

public interface SearchQueryService {

    SearchQueryRecord saveQuery(String query);

    List<SearchQueryRecord> getAllQueries();
}
