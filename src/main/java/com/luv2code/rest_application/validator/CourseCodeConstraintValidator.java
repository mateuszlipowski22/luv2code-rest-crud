package com.luv2code.rest_application.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        this.coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if(string!=null){
            result=string.startsWith(coursePrefix);
        }else {
            result = true;
        }

        return result;
    }
}
