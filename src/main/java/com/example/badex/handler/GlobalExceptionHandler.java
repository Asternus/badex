package com.example.badex.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity categoryNotFoundException(StudentNotFoundException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
