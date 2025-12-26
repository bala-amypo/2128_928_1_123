package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;

import java.util.List;

public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository recordRepository;
    private final EmployeeSkillRepository employeeSkillRepository;

    public SearchQueryServiceImpl(SearchQueryRecordRepository recordRepository,
                                  EmployeeSkillRepository employeeSkillRepository) {
        this.recordRepository = recordRepository;
        this.employeeSkillRepository = employeeSkillRepository;
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId) {

        if (skills == null || skills.isEmpty())
            throw new IllegalArgumentException("must not be empty");

        List<String> normalized = skills.stream()
                .map(s -> s.trim().toLowerCase())
                .distinct()
                .toList();

        List<Employee> result =
                employeeSkillRepository.findEmployeesByAllSkillNames(
                        normalized,
                        (long) normalized.size()
                );

        SearchQueryRecord record = new SearchQueryRecord();
        record.setSearcherId(searcherId);
        record.setSkillsRequested(String.join(",", normalized));
        record.setResultsCount(result.size());

        recordRepository.save(record);
        return result;
    }

    @Override
    public SearchQueryRecord getQueryById(Long id) {
        return recordRepository.findById(id).orElseThrow();
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(Long userId) {
        return recordRepository.findBySearcherId(userId);
    }

    @Override
    public void saveQuery(SearchQueryRecord record) {
        recordRepository.save(record);
    }
}
