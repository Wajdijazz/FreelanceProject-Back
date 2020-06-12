package com.freelance.app.services;

import java.util.Set;

import javax.mail.MessagingException;

import com.freelance.app.dto.UserDto;
import com.freelance.app.entities.Role;
import com.freelance.app.entities.User;

public interface IUserService {

	User createUser(UserDto userDto) throws MessagingException;

	User getUserById(Long userId);

	Role saveRole(Role role);

	Set<Role> affectRoleToUser(UserDto userDto);

	void sendMail(String messageToSend, String email, String password) throws MessagingException;

	User updatePasswordUser(UserDto userDto);

}
