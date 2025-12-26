package com.example.demo.controller;

import com.example.demo.dto.SearchQueryDTO;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchQueryController {

    @Autowired
    private SearchQueryService searchQueryService;

    @PostMapping
    public SearchQueryRecord createSearchQuery(@RequestBody SearchQueryDTO dto) {
        return searchQueryService.createSearchQuery(dto);
    }

    @GetMapping("/{searcherId}")
    public List<SearchQueryRecord> getQueriesByUser(@PathVariable Long searcherId) {
        return searchQueryService.getQueriesBySearcherId(searcherId);
    }
}
