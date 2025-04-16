package com.ghost.uwhub.msvc_users.domain.port.input;

import com.ghost.uwhub.msvc_users.domain.model.User;
import com.ghost.uwhub.msvc_users.domain.port.crud.DeletePort;
import com.ghost.uwhub.msvc_users.domain.port.crud.GetAllPort;
import com.ghost.uwhub.msvc_users.domain.port.crud.GetById;
import com.ghost.uwhub.msvc_users.domain.port.crud.UpdatePort;

public interface UserServicePort extends 
    GetAllPort<User>,
    GetById<User,String>,
    UpdatePort<User, String>,
    DeletePort<String>
{
    User login(User user);
    User register(User user);
}
