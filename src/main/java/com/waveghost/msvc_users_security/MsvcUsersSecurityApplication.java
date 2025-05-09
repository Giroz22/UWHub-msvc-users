package com.waveghost.msvc_users_security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.waveghost.msvc_users_security.adapter.output.persistence.entity.RoleEntity;
import com.waveghost.msvc_users_security.adapter.output.persistence.repository.RoleRepository;
import com.waveghost.msvc_users_security.infrastructure.enums.UserRole;

@SpringBootApplication
public class MsvcUsersSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcUsersSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner init(RoleRepository roleRepository) {
		return args -> {
			boolean hasRoles = roleRepository.findAll().size() > 0;

			if (!hasRoles) {
				roleRepository.save(new RoleEntity(null, UserRole.ADMIN));
				roleRepository.save(new RoleEntity(null, UserRole.USER));
			}
		};
	}

}
