package com.ltp.gradesubmission;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator<Score, String> {

    List<String> validValues = Arrays.asList(
            "A+", "A-", "A",
            "B+", "B-", "B",
            "C++", "C-", "C",
            "D+", "D-", "D",
            "F");

    @Override
    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        return validValues.contains(arg0);
    }
}
