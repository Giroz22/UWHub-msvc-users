package com.ghost.uwhub.msvc_users.domain.port.output;

import com.ghost.uwhub.msvc_users.domain.model.User;
import com.ghost.uwhub.msvc_users.domain.port.crud.CreatePort;
import com.ghost.uwhub.msvc_users.domain.port.crud.DeletePort;
import com.ghost.uwhub.msvc_users.domain.port.crud.GetAllPort;
import com.ghost.uwhub.msvc_users.domain.port.crud.GetById;
import com.ghost.uwhub.msvc_users.domain.port.crud.UpdatePort;

public interface UserPersistencePort extends 
    CreatePort<User>,
    GetAllPort<User>,
    GetById<User,String>,
    UpdatePort<User,String>,
    DeletePort<String>
{
    
}
