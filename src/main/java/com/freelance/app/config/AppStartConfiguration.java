package com.freelance.app.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.freelance.app.dto.UserDto;
import com.freelance.app.entities.CompanyClient;
import com.freelance.app.entities.Person;
import com.freelance.app.entities.Role;
import com.freelance.app.repositories.CompanyClientRepository;
import com.freelance.app.repositories.PersonRepository;

import com.freelance.app.services.IUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class AppStartConfiguration implements CommandLineRunner {
	private IUserService userService;
	private PersonRepository personRepository;
	private CompanyClientRepository companyClientRepository;

	@Override
	public void run(String... args) throws Exception {

		userService.saveRole(new Role(null, "SUPERADMIN"));
		userService.saveRole(new Role(null, "ADMIN"));
		userService.saveRole(new Role(null, "GESTIONARY"));
		userService.saveRole(new Role(null, "USER"));
		userService.saveRole(new Role(null, "AUDIT"));

		personRepository.save(new Person(null, "Mohamed Wajdi", "Jaziri", 545390739, LocalDate.now(), true));
		companyClientRepository.save(new CompanyClient(null, "ASMA", "www.demo.com", "Mohamed Wajdi",
				"Jaziri", "mohamedwajdijaziri@gmail.com", 54530739, null));

		Set<String> rolesSuperAdmin = new HashSet<>();
		rolesSuperAdmin.add("SUPERADMIN");
		Set<String> rolesAdmin = new HashSet<>();
		rolesAdmin.add("ADMIN");

		userService.createUser(
				new UserDto(null, "wajdijaziri@gmail.com", "wajdi12345", "wajdi12345", rolesSuperAdmin, true,1L,1L));
		userService.createUser(
				new UserDto(null, "admin@gmail.com", "wajdi12345", "wajdi12345", rolesAdmin, true,1L,1L));
		
	}
}
