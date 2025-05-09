package com.waveghost.msvc_users_security.domain.port.crud;

public interface UpdatePort<T,ID> {
    T update(ID id, T entity);
}
