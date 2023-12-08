package com.service.godash.Exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({ GenericException.class })
    public final ResponseEntity<Object> handleValidation(GenericException ex, WebRequest request) {
        return ResponseEntity.status(ex.getErrorCode()).body(ex.getMessage());
    }
}
