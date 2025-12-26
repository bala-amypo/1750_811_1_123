package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQuery;

import java.util.List;

public interface SearchQueryService {

    // Search employees by skill names for a specific employee
    List<Employee> searchEmployeesBySkills(List<String> skillNames, Long employeeId);

    // Get a specific search query by ID
    SearchQuery getQueryById(Long queryId);

    // Get all queries for a user
    List<SearchQuery> getQueriesForUser(Long userId);
}
