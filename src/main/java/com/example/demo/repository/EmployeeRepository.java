package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}

public interface SkillRepository extends JpaRepository<Skill, Long> { }

public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> { }

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {
    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);
    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);
    List<Employee> findEmployeesByAllSkillNames(List<String> skillNames, Long excludeId);
}

public interface SearchQueryRecordRepository extends JpaRepository<SearchQueryRecord, Long> {
    List<SearchQueryRecord> findBySearcherId(Long searcherId);
}
