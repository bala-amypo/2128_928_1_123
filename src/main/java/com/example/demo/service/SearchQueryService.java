package com.example.demo.service;

import com.example.demo.model.SearchQueryRecord;

import java.util.List;

public interface SearchQueryService {

    SearchQueryRecord saveQuery(SearchQueryRecord query);

    List<?> searchEmployeesBySkills(List<String> skills, Long userId);

    SearchQueryRecord getQueryById(Long id);

    List<SearchQueryRecord> getQueriesForUser(Long userId);
}
