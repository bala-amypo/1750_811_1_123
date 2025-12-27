package com.example.demo.controller;

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

    /**
     * Save a search query
     */
    @PostMapping
    public ResponseEntity<SearchQueryRecord> saveSearch(
            @RequestParam Long userId,
            @RequestBody List<String> skills
    ) {
        return ResponseEntity.ok(
                searchQueryService.saveSearch(userId, skills)
        );
    }

    /**
     * Get search history of a user
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SearchQueryRecord>> getSearchHistory(
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(
                searchQueryService.getQueriesForUser(userId)
        );
    }
}
