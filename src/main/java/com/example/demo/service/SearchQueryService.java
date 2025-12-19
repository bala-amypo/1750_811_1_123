package com.example.demo.service;

import com.example.demo.model.SearchQuery;
import com.example.demo.model.Employee;

import java.util.List;

public interface SearchQueryService {

    List<Employee> searchEmployeesBySkills(List<String> skills, Long userId);

    SearchQuery getQueryById(Long id);

    List<SearchQuery> getQueriesForUser(Long userId);
}
