package com.hoboss.validationdemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        ConstraintValidator.super.initialize(courseCode);
        this.coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        if (null != s && !s.isEmpty()) {
            result = s.startsWith(this.coursePrefix);
        } else {
            result = true;
        }
        return result;
    }
}
