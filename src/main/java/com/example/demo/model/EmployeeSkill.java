package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EmployeeSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    // getters
    public Long getId() { return id; }
    public boolean isActive() { return active; }
    public Employee getEmployee() { return employee; }
    public Skill getSkill() { return skill; }

    // setters
    public void setActive(boolean active) { this.active = active; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public void setSkill(Skill skill) { this.skill = skill; }
}
