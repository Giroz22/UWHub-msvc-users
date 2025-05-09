package com.waveghost.msvc_users_security.infrastructure.exceptions;

public class NicknameAlreadyExistExeption extends RuntimeException {
    public NicknameAlreadyExistExeption(){
        super("Ya existe un usuario con ese nickname");
    }
}
