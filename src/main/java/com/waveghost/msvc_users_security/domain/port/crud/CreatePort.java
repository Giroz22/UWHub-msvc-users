package com.waveghost.msvc_users_security.domain.port.crud;

public interface CreatePort<T> {
    T create(T entity);
}
