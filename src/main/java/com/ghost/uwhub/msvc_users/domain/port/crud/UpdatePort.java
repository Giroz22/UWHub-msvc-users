package com.ghost.uwhub.msvc_users.domain.port.crud;

public interface UpdatePort<T, ID> {
    T update(ID id, T entity);
}
