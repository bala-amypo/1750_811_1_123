package com.example.demo.util;

import java.util.Arrays;
import java.util.List;

public final class ProficiencyValidator {

    private static final List<String> VALID_LEVELS =
            Arrays.asList("Beginner", "Intermediate", "Advanced", "Expert");

    private ProficiencyValidator() {
        // utility class
    }

    public static void validate(String level) {
        if (level == null || !VALID_LEVELS.contains(level)) {
            throw new IllegalArgumentException("Invalid proficiency");
        }
    }
}
