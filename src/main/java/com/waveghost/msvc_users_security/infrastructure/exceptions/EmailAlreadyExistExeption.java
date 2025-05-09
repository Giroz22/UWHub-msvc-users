package com.waveghost.msvc_users_security.infrastructure.exceptions;

public class EmailAlreadyExistExeption extends RuntimeException {
    public EmailAlreadyExistExeption(){
        super("Ya existe un usuario con ese correo");
    }
}
