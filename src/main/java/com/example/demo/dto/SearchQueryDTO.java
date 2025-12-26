package com.example.demo.dto;

public class SearchQueryDTO {
    private Long searcherId;
    private String query;

    public Long getSearcherId() {
        return searcherId;
    }
    public void setSearcherId(Long searcherId) {
        this.searcherId = searcherId;
    }

    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
}
