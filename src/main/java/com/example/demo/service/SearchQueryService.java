package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.SearchQueryRecord;

public interface SearchQueryService {

    SearchQueryRecord create(SearchQueryRecord record);

    SearchQueryRecord getById(Long id);

    List<SearchQueryRecord> getAll();

    void delete(Long id);
}
