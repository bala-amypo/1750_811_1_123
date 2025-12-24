package com.example.demo.util;

public class ProficiencyValidator {

    public static boolean isValid(String proficiency) {
        return proficiency.equalsIgnoreCase("Beginner")
                || proficiency.equalsIgnoreCase("Intermediate")
                || proficiency.equalsIgnoreCase("Expert");
    }
}
