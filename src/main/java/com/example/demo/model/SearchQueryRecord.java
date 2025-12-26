package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SearchQueryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String query;

    // getters
    public Long getId() { return id; }
    public String getQuery() { return query; }

    // setters
    public void setQuery(String query) { this.query = query; }
}
