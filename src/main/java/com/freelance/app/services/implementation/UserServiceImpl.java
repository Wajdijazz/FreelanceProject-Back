package com.freelance.app.services.implementation;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.freelance.app.dto.UserDto;
import com.freelance.app.entities.Role;
import com.freelance.app.entities.User;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.exceptions.ResourceNotFoundException;
import com.freelance.app.repositories.RoleRepository;
import com.freelance.app.repositories.UserRepository;
import com.freelance.app.services.ICompanyClientService;
import com.freelance.app.services.IPersonService;
import com.freelance.app.services.IUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements IUserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private ICompanyClientService companyClientService;
	private IPersonService personService;
	private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(UserDto userDto) {
		if (userRepository.findByEmail(userDto.getEmail()) != null)
			throw new ResourceNotFoundException("User already exists");
		if (!userDto.getPassword().equals(userDto.getConfirmedPassword()))
			throw new ResourceNotFoundException("Please confirm your password");
		User userToSave = User.builder().email(userDto.getEmail())
				.password(passwordEncoder.encode(userDto.getPassword()))
				.person(personService.getPersonById(userDto.getPersonId()))
				.companyClient(companyClientService.getCompanyById(userDto.getCompanyClientId())).isActive(true)
				.build();

		userToSave.setRoles(affectRoleToUser(userDto));
		return userRepository.save(userToSave);

	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Set<Role> affectRoleToUser(UserDto userDto) {
		Set<String> strRoles = userDto.getRole();
		Set<Role> roles = new HashSet<>();
		strRoles.forEach(role -> {
			switch (role) {
			case "SUPERADMIN":
				Role SuperAdminRole = roleRepository.findByRoleDescription("SUPERADMIN")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(SuperAdminRole);
				break;

			case "ADMIN":
				Role AdminRole = roleRepository.findByRoleDescription("ADMIN")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(AdminRole);
				break;

			case "GESTIONARY":
				Role GestionnaryRole = roleRepository.findByRoleDescription("GESTIONARY")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(GestionnaryRole);
				break;

			case "USER":
				Role UserRole = roleRepository.findByRoleDescription("USER")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(UserRole);
				break;

			case "AUDIT":
				Role AuditRole = roleRepository.findByRoleDescription("AUDIT")
						.orElseThrow(() -> new ApplicationException("Fail! -> Cause: User Role not find."));
				roles.add(AuditRole);
				break;
			}

		});
		return roles;
	}

}
