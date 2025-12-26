package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployeeId(Long employeeId);

    List<EmployeeSkill> findBySkillId(Long skillId);

    @Query("""
        SELECT es.employee
        FROM EmployeeSkill es
        WHERE es.skill.name IN :skillNames
        GROUP BY es.employee
        HAVING COUNT(DISTINCT es.skill.name) = :#{#skillNames.size()}
    """)
    List<Employee> findEmployeesByAllSkillNames(List<String> skillNames);
}
