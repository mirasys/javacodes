package com.mirasysgroup.javacodes.controller.advice;

import com.mirasysgroup.javacodes.exceptions.BadRequestException;
import com.mirasysgroup.javacodes.models.CustomError;
import com.mirasysgroup.javacodes.models.Response;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
@ResponseBody
public class JavacodesApiAdvice extends ResponseEntityExceptionHandler {

    public static final String ERROR = "Api advice error: ";
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Response> handleException(BadRequestException ex){
        Response response = Response.builder()
                .code(ex.getCode())
                .message(ex.getMessage()).build();
        logger.error(ERROR,ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

//    //@ExceptionHandler
//    @Override
//    public ResponseEntity<List<CustomError>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        List<CustomError> errors = new ArrayList<>();
//
//        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
//            errors.add(new CustomError(fieldError.getField(), fieldError.getDefaultMessage()));
//        }
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
}
