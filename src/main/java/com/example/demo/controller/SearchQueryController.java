package com.example.demo.controller;

import com.example.demo.dto.SearchQueryDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchQueryController {

    private final SearchQueryService searchQueryService;

    public SearchQueryController(SearchQueryService searchQueryService) {
        this.searchQueryService = searchQueryService;
    }

    // 1. Search employees by skills
    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> searchEmployees(@RequestBody SearchQueryDTO dto) {
        if (dto.getSkills() == null || dto.getSkills().isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
        List<Employee> employees = searchQueryService.searchEmployeesBySkills(dto.getSkills(), dto.getSearcherId());
        return ResponseEntity.ok(employees);
    }

    // 2. Get search query by ID
    @GetMapping("/query/{id}")
    public ResponseEntity<SearchQueryRecord> getQueryById(@PathVariable Long id) {
        SearchQueryRecord record = searchQueryService.getQueryById(id);
        if (record == null) {
            throw new ResourceNotFoundException("SearchQueryRecord", "id", id);
        }
        return ResponseEntity.ok(record);
    }

    // 3. Get all queries for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SearchQueryRecord>> getQueriesForUser(@PathVariable Long userId) {
        List<SearchQueryRecord> queries = searchQueryService.getQueriesForUser(userId);
        return ResponseEntity.ok(queries);
    }
}
