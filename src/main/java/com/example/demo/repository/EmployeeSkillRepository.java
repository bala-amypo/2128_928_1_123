package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);

    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);

    @Query("""
        SELECT es.employee
        FROM EmployeeSkill es
        WHERE es.skill.name IN :skills
          AND es.employee.active = true
          AND es.skill.active = true
        GROUP BY es.employee
        HAVING COUNT(DISTINCT es.skill.name) = :#{#skills.size()}
    """)
    List<Employee> findEmployeesByAllSkillNames(@Param("skills") List<String> skills);
}
