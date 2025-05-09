package com.waveghost.msvc_users_security.adapter.input.api.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.waveghost.msvc_users_security.adapter.input.api.dtos.errors.ErrorResponse;
import com.waveghost.msvc_users_security.adapter.input.api.dtos.errors.ErrorsResponse;
import com.waveghost.msvc_users_security.infrastructure.exceptions.EntityNotFoundExeption;
import com.waveghost.msvc_users_security.infrastructure.exceptions.NicknameAlreadyExistExeption;
import com.waveghost.msvc_users_security.infrastructure.exceptions.RoleNotFoundExeption;
import com.waveghost.msvc_users_security.infrastructure.exceptions.EmailAlreadyExistExeption;

@RestControllerAdvice
public class GeneralErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> usernameNotFoundExceptionHandler(UsernameNotFoundException ex){
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .error(ex.getMessage())
            .build()
        );
    }    

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundExeption.class)
    public ResponseEntity<ErrorResponse> entityNotFoundExeptionHandler(EntityNotFoundExeption ex){
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .error(ex.getMessage())
            .build()
        );
    }  

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RoleNotFoundExeption.class)
    public ResponseEntity<ErrorResponse> roleNotFoundExeptionHandler(RoleNotFoundExeption ex){
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
            .error(ex.getMessage())
            .build()
        );
    } 

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorsResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex){
        return ResponseEntity.badRequest().body(
            ErrorsResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .errors(
                ex.getAllErrors().stream().map((err)->err.getDefaultMessage()).toList()
            )
            .build()
        );
    } 

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailAlreadyExistExeption.class)
    public ResponseEntity<ErrorResponse> emailAlreadyExistExeptionHandler(EmailAlreadyExistExeption ex){
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .error(ex.getMessage())
            .build()
        );
    } 

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NicknameAlreadyExistExeption.class)
    public ResponseEntity<ErrorResponse> nicknameAlreadyExistExeptionHandler(NicknameAlreadyExistExeption ex){
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .error(ex.getMessage())
            .build()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> badCredentialsExceptionHandler(BadCredentialsException ex){
        return ResponseEntity.badRequest().body(
            ErrorResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .status(HttpStatus.BAD_REQUEST.name())
            .error(ex.getMessage())
            .build()
        );
    }
    
}
