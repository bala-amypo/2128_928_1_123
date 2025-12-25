package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final EmployeeSkillRepository employeeSkillRepository;
    private final SearchQueryRecordRepository searchRepo;

    public SearchQueryServiceImpl(EmployeeSkillRepository employeeSkillRepository,
                                  SearchQueryRecordRepository searchRepo) {
        this.employeeSkillRepository = employeeSkillRepository;
        this.searchRepo = searchRepo;
    }

    @Override
    public SearchQueryRecord saveQuery(SearchQueryRecord query) {
        return searchRepo.save(query);
    }

    @Override
    public List<?> searchEmployeesBySkills(List<String> skills, Long userId) {

        if (skills == null || skills.isEmpty()) {
            throw new IllegalArgumentException("must not be empty");
        }

        List<?> employees =
                employeeSkillRepository.findEmployeesByAllSkillNames(skills, userId);

        SearchQueryRecord record = new SearchQueryRecord();
        record.setSearcherId(userId);
        record.setSkillsRequested(String.join(",", skills));
        record.setResultsCount(employees.size());

        searchRepo.save(record);

        return employees;
    }

    @Override
    public SearchQueryRecord getQueryById(Long id) {
        return searchRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Query not found"));
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(Long userId) {
        return searchRepo.findBySearcherId(userId);
    }
}
