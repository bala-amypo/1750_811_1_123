package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "skills",
        uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String category;

    private String description;

    @Column(nullable = false)
    private Boolean active = true;

    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private List<EmployeeSkill> employeeSkills;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getActive() {
        return active;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
