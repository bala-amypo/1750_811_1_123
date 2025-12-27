package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;

import java.util.List;

public interface SearchQueryService {

    // Search employees by skill names
    List<Employee> searchEmployeesBySkills(List<String> skillNames, Long userId);

    // Get search query by ID
    SearchQueryRecord getQueryById(Long id);

    // Get past queries for user
    List<SearchQueryRecord> getQueriesForUser(Long userId);
}
