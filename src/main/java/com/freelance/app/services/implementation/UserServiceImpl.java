package com.freelance.app.services.implementation;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.freelance.app.dto.UserDto;
import com.freelance.app.entities.Role;
import com.freelance.app.entities.User;
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
		// TODO Auto-generated method stub
		if (userRepository.findByEmail(userDto.getEmail()) != null)
			throw new ResourceNotFoundException("User already exists");
		if (!userDto.getPassword().equals(userDto.getConfirmedPassword()))
			throw new ResourceNotFoundException("Please confirm your password");
		User userToSave = User.builder()
				.email(userDto.getEmail())
				.password(passwordEncoder.encode(userDto.getPassword()))
				.person(personService.getPersonById(userDto.getPersonId()))
				.companyClient(companyClientService.getCompanyById(userDto.getCompanyClientId()))
				.isActive(true)
				.build();
		addRoleToUser(userToSave, "SUPERADMIN");	
		return userRepository.save(userToSave);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(User user, String roleDescription) {
		// TODO Auto-generated method stub
		Role appRole = roleRepository.findByRoleDescription(roleDescription);
		Set<Role> roles = new HashSet<>();
		roles.add(appRole);
		user.setRoles((roles));

	}

}
