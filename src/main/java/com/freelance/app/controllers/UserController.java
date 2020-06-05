package com.freelance.app.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.app.converter.UserConvertor;
import com.freelance.app.dto.UserDto;
import com.freelance.app.services.IUserService;
import com.freelance.app.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.USER)
public class UserController {

	private IUserService userService;
	private UserConvertor userConvertor;

	@PostMapping("/register")
	public UserDto createUser(@RequestBody UserDto userDto) {
		return userConvertor.entityToDto(userService.createUser(userDto));
	}

}
