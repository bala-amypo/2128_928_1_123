package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.model.Skill;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

private final EmployeeSkillRepository employeeSkillRepository;
private final EmployeeRepository employeeRepository;
private final SkillRepository skillRepository;

/* REQUIRED constructor */
public EmployeeSkillServiceImpl(
EmployeeSkillRepository employeeSkillRepository,
EmployeeRepository employeeRepository,
SkillRepository skillRepository
) {
this.employeeSkillRepository = employeeSkillRepository;
this.employeeRepository = employeeRepository;
this.skillRepository = skillRepository;
}

@Override
public EmployeeSkill assignSkillToEmployee(Long employeeId, Long skillId) {

Employee employee = employeeRepository.findById(employeeId)
.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

Skill skill = skillRepository.findById(skillId)
.orElseThrow(() -> new ResourceNotFoundException("Skill not found"));

EmployeeSkill es = new EmployeeSkill();
es.setEmployee(employee);
es.setSkill(skill);
es.setActive(true);

return employeeSkillRepository.save(es);
}

@Override
public List<EmployeeSkill> getAllEmployeeSkills() {
return employeeSkillRepository.findAll();
}
}
