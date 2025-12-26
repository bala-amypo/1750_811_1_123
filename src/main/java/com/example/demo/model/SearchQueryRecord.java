package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SearchQueryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String query;
    private Long searcherId;

    public String getQuery() { return query; }
    public void setQuery(String query) { this.query = query; }

    public Long getSearcherId() { return searcherId; }
    public void setSearcherId(Long searcherId) { this.searcherId = searcherId; }
}
