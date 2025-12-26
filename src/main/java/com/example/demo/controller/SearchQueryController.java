package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    private final SearchQueryService searchService;
    public SearchQueryController(SearchQueryService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public ResponseEntity<List<Employee>> searchEmployees(@RequestBody List<String> skills,
                                                          @RequestParam Long searcherId) {
        return ResponseEntity.ok(searchService.searchEmployeesBySkills(skills, searcherId));
    }

    @GetMapping("/query/{id}")
    public ResponseEntity<SearchQueryRecord> getQueryById(@PathVariable Long id) {
        return ResponseEntity.ok(searchService.getQueryById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SearchQueryRecord>> getQueriesForUser(@PathVariable Long userId) {
        return ResponseEntity.ok(searchService.getQueriesForUser(userId));
    }
}
