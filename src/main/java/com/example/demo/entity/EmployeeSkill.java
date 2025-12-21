package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_skills")
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(nullable = false)
    private String proficiencyLevel;

    @Column(nullable = false)
    private Integer yearsOfExperience;

    @Column(nullable = false)
    private Boolean active = true;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Skill getSkill() {
        return skill;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public Boolean getActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
