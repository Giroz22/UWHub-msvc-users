package com.waveghost.msvc_users_security.domain.port.crud;

import java.util.List;

public interface GetAllPort<T> {
    List<T> getAll();
}
