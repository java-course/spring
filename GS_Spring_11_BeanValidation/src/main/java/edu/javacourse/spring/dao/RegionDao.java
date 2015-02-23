package edu.javacourse.spring.dao;

import edu.javacourse.spring.model.Region;
import edu.javacourse.spring.validation.RegionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Set;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class RegionDao {


    public void createRegion(Region region) {

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        Set<ConstraintViolation<Region>> constraintViolations  = validator.validate(region);

        System.out.println(String.format("Кол-во ошибок: %d", constraintViolations.size()));

        for (ConstraintViolation<Region> cv : constraintViolations)
            System.out.println(String.format(
                    "Внимание, ошибка! property: [%s], value: [%s], message: [%s]",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));

        System.out.println("Region Saved...");

    }

}
