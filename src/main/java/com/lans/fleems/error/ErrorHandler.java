package com.lans.fleems.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;


@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<?> notFoundHandler(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<?> illegalArgumentHandler(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(Exception ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> defaultErrorHandler(Exception ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
