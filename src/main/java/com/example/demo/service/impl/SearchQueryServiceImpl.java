// package com.example.demo.service.impl;

// import com.example.demo.model.SearchQuery;
// import com.example.demo.repository.SearchQueryRepository;
// import com.example.demo.service.SearchQueryService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class SearchQueryServiceImpl implements SearchQueryService {

//     private final SearchQueryRepository repository;

//     public SearchQueryServiceImpl(SearchQueryRepository repository) {
//         this.repository = repository;
//     }

//     @Override
//     public List<SearchQuery> getQueriesForUser(Long userId) {
//         return repository.findByUserId(userId);
//     }

//     @Override
//     public SearchQuery getQueryById(Long id) {
//         return repository.findById(id).orElse(null);
//     }
// }
