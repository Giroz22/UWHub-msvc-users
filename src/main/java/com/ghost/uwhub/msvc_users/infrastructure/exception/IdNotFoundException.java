package com.ghost.uwhub.msvc_users.infrastructure.exception;

public class IdNotFoundException extends RuntimeException{
    private static String ERROR_MESSAGE = "No se encontró un %s con ese ID.";

    public IdNotFoundException(String entityName){
        super(String.format(ERROR_MESSAGE, entityName));
    }
}
