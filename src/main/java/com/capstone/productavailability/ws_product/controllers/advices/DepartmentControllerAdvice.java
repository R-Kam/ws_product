package com.capstone.productavailability.ws_product.controllers.advices;

import com.capstone.productavailability.ws_product.controllers.DepartmentController;
import com.capstone.productavailability.ws_product.controllers.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ElementKind;
import javax.validation.Path;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestControllerAdvice(assignableTypes = {DepartmentController.class, ProductController.class})
public class DepartmentControllerAdvice {
    @Autowired
    private Environment env;
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> invalidParamsExceptionHandler(ConstraintViolationException e){
        String message = resolveConstraintViolations(e.getConstraintViolations());
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .message(message)
//                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<?> invalidParamsExceptionHandler(MethodArgumentNotValidException e){
        String message = resolveBindingResultErrors(e.getBindingResult());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    private String resolveBindingResultErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(fr -> {
                    String field = fr.getField();
                    String validationMessage = env.getProperty(fr.getDefaultMessage());
                    return String.format("Error : '%s'", validationMessage);
                })
                .collect(Collectors.joining(", "));
    }

    private String resolveConstraintViolations(Collection<ConstraintViolation<?>> constraintViolations) {
        return constraintViolations.stream()
                .map(cv -> {
                    String parameter = getParameterName(cv);
                    String validationMessage = cv.getMessage();
                    return String.format("'%s': %s", parameter, validationMessage);
                })
                .collect(Collectors.joining(", "));
    }

    private String getParameterName(ConstraintViolation constraintViolation) {
        return StreamSupport.stream(constraintViolation.getPropertyPath().spliterator(), false)
                .filter(p -> p.equals(ElementKind.PARAMETER))
                .findFirst()
                .map(Path.Node::getName)
                .orElse(null);
    }
}
