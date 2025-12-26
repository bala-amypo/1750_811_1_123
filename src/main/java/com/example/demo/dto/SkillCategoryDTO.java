package com.example.demo.dto;

public class SkillCategoryDTO {
    private Long id;
    private String categoryName;
    private Boolean active;

    public SkillCategoryDTO() {}

    public SkillCategoryDTO(Long id, String categoryName, Boolean active) {
        this.id = id;
        this.categoryName = categoryName;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    @Override
    public String toString() {
        return "SkillCategoryDTO{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", active=" + active +
                '}';
    }
}
