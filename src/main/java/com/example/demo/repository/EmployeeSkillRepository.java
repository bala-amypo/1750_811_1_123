package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    // ✅ Used by EmployeeSkillServiceImpl
    List<EmployeeSkill> findByEmployee_Id(Long employeeId);

    // ✅ Used by EmployeeSkillServiceImpl
    List<EmployeeSkill> findBySkill_Id(Long skillId);

    // ✅ Used by SearchQueryServiceImpl
    @Query("""
        SELECT es.employee
        FROM EmployeeSkill es
        WHERE LOWER(es.skill.name) IN :skillNames
          AND es.employee.active = true
        GROUP BY es.employee
        HAVING COUNT(DISTINCT es.skill.name) = :skillCount
    """)
    List<Employee> findEmployeesByAllSkillNames(
            @Param("skillNames") List<String> skillNames,
            @Param("skillCount") Long skillCount
    );
}
