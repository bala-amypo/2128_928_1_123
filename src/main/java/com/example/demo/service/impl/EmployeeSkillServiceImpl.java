package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

private final EmployeeSkillRepository repository;

public EmployeeSkillServiceImpl(EmployeeSkillRepository repository) {
this.repository = repository;
}

@Override
public EmployeeSkill assignSkill(EmployeeSkill employeeSkill) {
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

@Override
public List<Object> searchEmployeesBySkills(List<String> skillNames) {
return repository.findEmployeesByAllSkillNames(skillNames, skillNames.size());

}
}
