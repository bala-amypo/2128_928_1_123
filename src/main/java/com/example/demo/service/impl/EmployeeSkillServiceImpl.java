package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.EmployeeSkillService;

import java.util.List;

public class EmployeeSkillServiceImpl implements EmployeeSkillService {

private final EmployeeSkillRepository employeeSkillRepository;
private final EmployeeRepository employeeRepository;
private final SkillRepository skillRepository;

public EmployeeSkillServiceImpl(EmployeeSkillRepository employeeSkillRepository,
EmployeeRepository employeeRepository,
SkillRepository skillRepository) {
this.employeeSkillRepository = employeeSkillRepository;
this.employeeRepository = employeeRepository;
this.skillRepository = skillRepository;
}

public List<EmployeeSkill> getByEmployeeId(Long id) {
return employeeSkillRepository.findByEmployeeId(id);
}

public List<EmployeeSkill> getBySkillId(Long id) {
return employeeSkillRepository.findBySkillId(id);
}

public List<Employee> searchEmployeesBySkills(List<String> skills) {
return employeeSkillRepository.findEmployeesByAllSkillNames(skills);
}
}
