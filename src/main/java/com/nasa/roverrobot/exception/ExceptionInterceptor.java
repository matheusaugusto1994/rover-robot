package com.nasa.roverrobot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidCommandException.class)
    public final ResponseEntity<CustomDetailsException> handleAllExceptions(InvalidCommandException ex) {
        var customException = CustomDetailsException.builder()
            .message(ex.getMessage())
            .details(ex.getDetails())
            .build();
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPositionException.class)
    public final ResponseEntity<CustomDetailsException> handleAllExceptions(InvalidPositionException ex) {
        var customException = CustomDetailsException.builder()
            .message(ex.getMessage())
            .details(ex.getDetails())
            .build();
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }
}
