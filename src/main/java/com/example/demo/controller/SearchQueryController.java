package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQuery;
import com.example.demo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    @Autowired
    private SearchQueryService searchService;

    @PostMapping("/employees")
    public List<Employee> searchEmployeesBySkills(@RequestBody List<String> skillNames,
                                                  @RequestParam Long employeeId) {
        return searchService.searchEmployeesBySkills(skillNames, employeeId);
    }

    @GetMapping("/query/{queryId}")
    public SearchQuery getQueryById(@PathVariable Long queryId) {
        return searchService.getQueryById(queryId);
    }

    @GetMapping("/user/{userId}")
    public List<SearchQuery> getQueriesForUser(@PathVariable Long userId) {
        return searchService.getQueriesForUser(userId);
    }
}
