package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface SearchQueryService {

    List<Employee> searchEmployeesBySkillIds(List<Long> skillIds);

    // REQUIRED method (this caused the error)
    List<String> getQueriesForUser(Long userId);
}
