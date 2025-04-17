package com.ghost.uwhub.msvc_users.adapter.input.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ghost.uwhub.msvc_users.adapter.input.api.dto.error.ErrorResponse;
import com.ghost.uwhub.msvc_users.infrastructure.exception.IdNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler (IdNotFoundException.class)
    public ResponseEntity<ErrorResponse> idNotFound(IdNotFoundException ex){
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .message(ex.getMessage())
            .build()
        );
    }
}
