package com.assignment.backend.annotaion;

import com.assignment.backend.validation.PasswordConstraintValidator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;

import javax.validation.Payload;
import javax.validation.Constraint;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface ValidPassword {

    String message() default "Password must be at least 8 characters, contains uppercase, lowercase, number and special characters";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
