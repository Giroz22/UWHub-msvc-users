package com.ghost.uwhub.msvc_users.domain.port.crud;

public interface CreatePort<T> {
    T create(T entity);
}
