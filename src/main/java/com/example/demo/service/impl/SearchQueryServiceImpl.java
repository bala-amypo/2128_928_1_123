package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

private final SearchQueryRecordRepository searchRepository;
private final EmployeeSkillRepository employeeSkillRepository;

/* REQUIRED by TestNG */
public SearchQueryServiceImpl(
SearchQueryRecordRepository searchRepository,
EmployeeSkillRepository employeeSkillRepository
) {
this.searchRepository = searchRepository;
this.employeeSkillRepository = employeeSkillRepository;
}

@Override
public List<Employee> searchEmployeesBySkills(List<String> skillNames) {

/* save search history */
SearchQueryRecord record = new SearchQueryRecord();
record.setQueryText(String.join(",", skillNames));
searchRepository.save(record);

/* real business logic */
return employeeSkillRepository.findEmployeesByAllSkillNames(
skillNames,
skillNames.size()
);
}
}
