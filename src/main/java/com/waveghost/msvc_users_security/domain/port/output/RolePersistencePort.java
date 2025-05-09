package com.waveghost.msvc_users_security.domain.port.output;

import com.waveghost.msvc_users_security.domain.model.RoleModel;
import com.waveghost.msvc_users_security.infrastructure.enums.UserRole;

public interface RolePersistencePort {
    RoleModel findByUserRole(UserRole role);
}
