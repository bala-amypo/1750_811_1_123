package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchQueryService searchQueryService;

    public SearchController(SearchQueryService searchQueryService) {
        this.searchQueryService = searchQueryService;
    }

    // POST - search employees by skills
    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> searchEmployees(
            @RequestBody List<String> skills,
            @RequestParam Long searcherId) {
        return ResponseEntity.ok(
                searchQueryService.searchEmployeesBySkills(skills, searcherId));
    }

    // GET - search query by id
    @GetMapping("/{id}")
    public ResponseEntity<SearchQueryRecord> getQueryById(@PathVariable Long id) {
        return ResponseEntity.ok(searchQueryService.getQueryById(id));
    }

    // GET - queries for user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SearchQueryRecord>> getQueriesForUser(
            @PathVariable Long userId) {
        return ResponseEntity.ok(searchQueryService.getQueriesForUser(userId));
    }
}
