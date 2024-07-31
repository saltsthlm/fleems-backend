package com.lans.fleems.error.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;


@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> notFoundHandler(NoSuchElementException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> illegalArgumentHandler(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> defaultErrorHandler(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
