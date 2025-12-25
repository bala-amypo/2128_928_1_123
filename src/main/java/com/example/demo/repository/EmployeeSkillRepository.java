package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    // ✔ Used by service
    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);

    // ✔ Used by service
    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);

    // ✔ Search by multiple skills (test-case requirement)
    @Query("""
        SELECT es.employee
        FROM EmployeeSkill es
        WHERE es.skill.name IN :skills
          AND es.employee.active = true
          AND es.skill.active = true
          AND (:userId IS NULL OR es.employee.id <> :userId)
        GROUP BY es.employee
        HAVING COUNT(DISTINCT es.skill.name) = :#{#skills.size()}
    """)
    List<Employee> findEmployeesByAllSkillNames(
            @Param("skills") List<String> skills,
            @Param("userId") Long userId
    );
}
