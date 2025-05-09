package com.waveghost.msvc_users_security.infrastructure.exceptions;

public class EntityNotFoundExeption extends RuntimeException {
    public EntityNotFoundExeption(String message){
        super(message);
    }
}
