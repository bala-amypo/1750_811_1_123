package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
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
                                          @RequestParam Long searcherId) {
        return searchQueryService.searchEmployeesBySkills(skills, searcherId);
    }

    @GetMapping("/queries/{id}")
    public SearchQueryRecord getQuery(@PathVariable Long id) {
        return searchQueryService.getQueryById(id);
    }

    @GetMapping("/queries/user/{searcherId}")
    public List<SearchQueryRecord> getQueriesForUser(@PathVariable Long searcherId) {
        return searchQueryService.getQueriesForUser(searcherId);
    }
}
