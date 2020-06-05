package com.freelance.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.freelance.app.entities.Role;
import com.freelance.app.services.IUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class AppStartConfiguration implements CommandLineRunner {
	private IUserService userService;

	@Override
	public void run(String... args) throws Exception {
		userService.saveRole(new Role(null, "SUPERADMIN", null));
		userService.saveRole(new Role(null, "ADMIN", null));
		userService.saveRole(new Role(null, "GESTIONARY", null));
		userService.saveRole(new Role(null, "USER", null));
		userService.saveRole(new Role(null, "AUDIT", null));
	}
}
