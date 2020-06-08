package com.freelance.app.services;

import java.util.Set;

import com.freelance.app.dto.UserDto;
import com.freelance.app.entities.Role;
import com.freelance.app.entities.User;

public interface IUserService {

	User createUser(UserDto userDto);

	Role saveRole(Role role);
	
	Set<Role> affectRoleToUser(UserDto userDto);
	

}
