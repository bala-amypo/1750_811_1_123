package com.example.demo.controller;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search-records")
public class SearchQueryRecordController {

    private final SearchQueryRecordRepository searchQueryRecordRepository;

    public SearchQueryRecordController(
            SearchQueryRecordRepository searchQueryRecordRepository) {
        this.searchQueryRecordRepository = searchQueryRecordRepository;
    }

    // 📄 Get all search records
    @GetMapping
    public List<SearchQueryRecord> getAllSearchRecords() {
        return searchQueryRecordRepository.findAll();
    }

    // 🔍 Get search records by type
    @GetMapping("/type/{type}")
    public List<SearchQueryRecord> getBySearchType(@PathVariable String type) {
        return searchQueryRecordRepository.findBySearchType(type);
    }

    // ⏱ Get last 10 recent searches
    @GetMapping("/recent")
    public List<SearchQueryRecord> getRecentSearches() {
        return searchQueryRecordRepository.findTop10ByOrderBySearchedAtDesc();
    }
}
