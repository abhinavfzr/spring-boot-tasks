package com.stackroute.userservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdviceException {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionhandler(Exception e) {
        return new ResponseEntity<>("erorr exception occured GloabalBhai " + e.getMessage(), HttpStatus.CONFLICT);
    }
}