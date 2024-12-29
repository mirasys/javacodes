package com.mirasysgroup.javacodes.utils;

import com.mirasysgroup.javacodes.models.CustomError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class TransactionUtils {

    public static List<CustomError> getFieldErrors(Errors errors) {
        if (errors.hasFieldErrors()) {
            List<FieldError> errorList = errors.getFieldErrors();
            List<CustomError> issues = new ArrayList<>();
            for (FieldError error : errorList) {
                issues.add(new CustomError(error.getField(),error.getDefaultMessage()));
            }
            log.info(issues.toString());
            return issues;
        }
        return null;
    }
}
