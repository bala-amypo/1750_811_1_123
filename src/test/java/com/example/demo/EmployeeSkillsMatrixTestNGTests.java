package com.example.demo;

import org.testng.annotations.Test;
import org.testng.Assert;

public class EmployeeSkillsMatrixTestNGTests {

    // Example test 1
    @Test
    public void testEmployeeCreation() {
        // Example: pretend we create an employee
        String employeeName = "John Doe";
        Assert.assertNotNull(employeeName, "Employee name should not be null");
    }

    // Example test 2
    @Test
    public void testSkillAssignment() {
        // Example: pretend we assign skill to employee
        String skill = "Java";
        boolean assigned = true; // simulate assignment
        Assert.assertTrue(assigned, "Skill should be assigned");
    }

    // Example test 3
    @Test
    public void testSkillMatrixValidation() {
        int totalEmployees = 5;
        int totalSkills = 10;
        int matrixSize = totalEmployees * totalSkills;
        Assert.assertEquals(matrixSize, 50, "Matrix size calculation should match");
    }

}
