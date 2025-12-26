package com.example.demo.service.impl;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

private final EmployeeSkillRepository repository;

public EmployeeSkillServiceImpl(EmployeeSkillRepository repository) {
this.repository = repository;
}

@Override
public EmployeeSkill addSkillToEmployee(EmployeeSkill employeeSkill) {
employeeSkill.setActive(true);
return repository.save(employeeSkill);
}

@Override
public List<EmployeeSkill> getSkillsByEmployee(Long employeeId) {
return repository.findByEmployeeId(employeeId);
}

@Override
public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
return repository.findBySkillId(skillId);
}

/*
 CORE MATRIX SEARCH LOGIC
 */
@Override
public List<Long> searchEmployeesBySkillNames(List<String> skillNames) {
return repository.findEmployeeIdsBySkillNames(skillNames, skillNames.size());
}
}
