package com.hcl.tms_ver2.common.validation;

import javax.validation.ConstraintValidator;
import java.lang.annotation.*;

@Documented
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraint {
    Class<? extends ConstraintValidator<?, ?>>[] validatedBy();
}
