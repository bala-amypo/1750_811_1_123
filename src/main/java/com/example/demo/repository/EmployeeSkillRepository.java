package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    @Query("""
        SELECT DISTINCT es.employee
        FROM EmployeeSkill es
        WHERE es.active = true
          AND es.employee.active = true
          AND es.skill.name IN :skills
        GROUP BY es.employee
        HAVING COUNT(DISTINCT es.skill.name) = :skillCount
    """)
    List<Employee> findEmployeesByAllSkillNames(
            @Param("skills") List<String> skills,
            @Param("skillCount") long skillCount
    );

    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);

    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);
}
