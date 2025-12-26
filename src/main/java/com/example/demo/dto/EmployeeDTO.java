package com.example.demo.dto;

public class EmployeeDTO {
    private String fullName;
    private String email;
    // Getters & Setters
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

public class SkillDTO {
    private String name;
    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

public class SkillCategoryDTO {
    private String categoryName;
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
