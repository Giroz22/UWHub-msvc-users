package com.waveghost.msvc_users_security.infrastructure.exceptions;

public class RoleNotFoundExeption extends RuntimeException {
    
    private static String ERROR_MESSAGE = "El rol %s, no fue encontrado en la base de datos";

    public RoleNotFoundExeption(String roleName){
        super(String.format(ERROR_MESSAGE, roleName));
    }
}
