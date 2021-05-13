package com.hcl.tms_ver2.common.validation;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class FieldMatchValidator  implements ConstraintValidator<FieldMatch, Object> {
    private String firstFileName;

    private String secondFileName;

    private String message;


    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFileName = constraintAnnotation.first();
        secondFileName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object o, final ConstraintValidatorContext constraintValidatorContext) {
        boolean validFlag = true;

        try {
            final Object firstObj = BeanUtils.getProperty(o, firstFileName);
            final Object secondObj = BeanUtils.getProperty(o, secondFileName);

            validFlag = ObjectUtils.isEmpty(firstObj) || ObjectUtils.isArray(secondObj) || firstObj.equals(secondObj);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (!validFlag) {
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(secondFileName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return validFlag;
    }
}
