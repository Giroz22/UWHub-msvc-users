package com.waveghost.msvc_users_security.domain.port.crud;

public interface GetByIdPort<T,ID> {
    T getById(ID id);
}
