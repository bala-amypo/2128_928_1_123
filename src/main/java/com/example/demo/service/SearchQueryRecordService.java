package com.example.demo.service;

import com.example.demo.entity.SearchQueryRecord;
import java.util.List;

public interface SearchQueryService {

    SearchQueryRecord createQuery(SearchQueryRecord record);

    SearchQueryRecord getQueryById(Long id);

    List<SearchQueryRecord> getAllQueries();

    void deleteQuery(Long id);
}
