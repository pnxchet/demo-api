package com.demo.demoapi.adapter.inbound.handler;

import com.demo.demoapi.adapter.inbound.communication.CommonResponse;
import com.demo.demoapi.application.exception.DatabaseErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DatabaseErrorException.class)
    public ResponseEntity<CommonResponse> handleDatabaseErrorException(DatabaseErrorException ex) {
        CommonResponse response = new CommonResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), ex.getMessage());
        return new ResponseEntity<>(
                response, HttpStatus.SERVICE_UNAVAILABLE
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonResponse> handleAllExceptions(Exception ex) {
        CommonResponse response = new CommonResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred"
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}