package com.ghost.uwhub.msvc_users.domain.port.crud;

import java.util.List;

public interface GetAllPort<T> {
    List<T> getAll();
}
