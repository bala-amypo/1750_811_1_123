package com.example.demo.dto;

import java.util.List;

public class EmployeeSearchRequest {

    private List<String> skills;
    private Long searcherId;

    public EmployeeSearchRequest() {
    }

    public EmployeeSearchRequest(List<String> skills, Long searcherId) {
        this.skills = skills;
        this.searcherId = searcherId;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Long getSearcherId() {
        return searcherId;
    }

    public void setSearcherId(Long searcherId) {
        this.searcherId = searcherId;
    }
}
