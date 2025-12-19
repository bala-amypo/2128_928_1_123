package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeSkillRepo;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillImpl implements EmployeeSkillService {

private final EmployeeSkillRepository employeeSkillRepository;

public EmployeeSkillImpl(EmployeeSkillRepository employeeSkillRepository) {
this.employeeSkillRepository = employeeSkillRepository;
}

@Override
public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {
return employeeSkillRepository.save(employeeSkill);
}

@Override
public EmployeeSkill getEmployeeSkillById(Long id) {
return employeeSkillRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("EmployeeSkill not found with id: " + id));
}

@Override
public List<EmployeeSkill> getAllEmployeeSkills() {
return employeeSkillRepository.findAll();
}

@Override
public void deleteEmployeeSkill(Long id) {
EmployeeSkill employeeSkill = employeeSkillRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("EmployeeSkill not found with id: " + id));

employeeSkillRepository.delete(employeeSkill);
}
}
