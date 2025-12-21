package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchQueryService searchQueryService;

    public SearchController(SearchQueryService searchQueryService) {
        this.searchQueryService = searchQueryService;
    }

    @PostMapping("/employees")
    public List<Employee> searchEmployees(@RequestBody List<String> skills,
                                          @RequestParam Long userId) {
        return searchQueryService.searchEmployeesBySkills(skills, userId);
    }

    @GetMapping("/queries/{id}")
    public SearchQueryRecord getQuery(@PathVariable Long id) {
        return searchQueryService.getQueryById(id);
    }

    @GetMapping("/queries/user/{userId}")
    public List<SearchQueryRecord> getQueriesForUser(@PathVariable Long userId) {
        return searchQueryService.getQueriesForUser(userId);
    }
}
