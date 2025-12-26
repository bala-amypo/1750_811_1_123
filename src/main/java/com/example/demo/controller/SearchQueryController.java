package com.example.demo.controller;

import com.example.demo.dto.SearchQueryDTO;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchQueryController {

    private final SearchQueryService searchQueryService;

    public SearchQueryController(SearchQueryService searchQueryService) {
        this.searchQueryService = searchQueryService;
    }

    @PostMapping
    public SearchQueryRecord saveQuery(@RequestBody SearchQueryDTO dto, @RequestParam Long searcherId) {
        return searchQueryService.saveQuery(dto, searcherId);
    }
}
