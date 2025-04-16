package com.ghost.uwhub.msvc_users.domain.port.crud;

public interface GetById<T, ID> {
    T getById(ID id);
}
