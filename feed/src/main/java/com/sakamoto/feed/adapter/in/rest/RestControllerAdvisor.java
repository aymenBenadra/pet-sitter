package com.sakamoto.feed.adapter.in.rest;

import com.sakamoto.feed.core.port.out.persistence.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestControllerAdvisor {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ResponseRecord<?>> handlePostNotFoundException(RuntimeException e) {
        return new ResponseEntity<>(new ResponseRecord<>(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseRecord<Map<String, String>>> handleValidationException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        Map<String, String> violations = new HashMap<>();
        result.getFieldErrors().forEach(fieldError ->
                violations.put(fieldError.getField(), fieldError.getDefaultMessage()));

        return new ResponseEntity<>(new ResponseRecord<>(HttpStatus.BAD_REQUEST, "Validation Error", violations), HttpStatus.BAD_REQUEST);
    }
}
