package com.inkafarma.personsapi.util.exception;

import com.inkafarma.personsapi.model.ResponseError;
import com.inkafarma.personsapi.model.ResponseErrorDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ResponseError> DataNotFoundException(
            DataNotFoundException ex) {

        ResponseError response = new ResponseError("Error DataNotFound");
        ResponseErrorDetail responseErrorDetail = new ResponseErrorDetail(ex.getMessage());
        response.setErrors(Arrays.asList(responseErrorDetail));
        return new ResponseEntity<>(response, new HttpHeaders(),HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseError> handleAllExceptions(Exception ex) {


        ResponseError response = new ResponseError("General Exception");
        log.error("error",ex);
        ResponseErrorDetail responseErrorDetail = new ResponseErrorDetail(ex.getMessage());
        response.setErrors(Arrays.asList(responseErrorDetail));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<ResponseError> customValidationException(
            CustomValidationException ex) {

        List<ResponseErrorDetail> responseErrorList= ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> new ResponseErrorDetail(
                        fieldError.getField(),
                        fieldError.getCode(),
                        fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        ResponseError response = new ResponseError("Error in Validations");
        response.setErrors(responseErrorList);

        return new ResponseEntity<>(response, new HttpHeaders(),HttpStatus.BAD_REQUEST);

    }
}
