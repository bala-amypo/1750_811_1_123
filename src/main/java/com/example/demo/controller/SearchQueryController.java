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

    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestBody List<String> skills,
                                                          @RequestParam Long searcherId) {
        List<Employee> result = searchService.searchEmployeesBySkills(skills, searcherId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/queries/{id}")
    public ResponseEntity<SearchQueryRecord> getQuery(@PathVariable Long id) {
        SearchQueryRecord record = searchService.getQueryById(id);
        return ResponseEntity.ok(record);
    }

    @GetMapping("/queries/user/{userId}")
    public ResponseEntity<List<SearchQueryRecord>> getQueriesForUser(@PathVariable Long userId) {
        List<SearchQueryRecord> queries = searchService.getQueriesForUser(userId);
        return ResponseEntity.ok(queries);
    }
}
