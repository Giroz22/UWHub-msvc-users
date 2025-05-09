package com.waveghost.msvc_users_security.domain.port.crud;

public interface DeletePort<ID> {
    void delete(ID id);
}
