package com.example.demo.dto;

public class EmployeeSkillDTO {
    private Long employeeId;
    private Long skillId;
    private boolean active;
    private int yearsOfExperience;

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public Long getSkillId() { return skillId; }
    public void setSkillId(Long skillId) { this.skillId = skillId; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
}
