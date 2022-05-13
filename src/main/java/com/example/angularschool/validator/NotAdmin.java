package com.example.angularschool.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EnterAdminConstraint.class})
public @interface NotAdmin {

    String message() default "{course.name.valid.msg}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };

}
