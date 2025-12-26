package com.example.demo.util;

import java.util.List;

public class ProficiencyValidator {

    private static final List<String> LEVELS =
            List.of("Beginner", "Intermediate", "Advanced", "Expert");

    public static boolean isValid(String level) {
        return LEVELS.contains(level);
    }
}
