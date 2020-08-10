package com.freelance.app.converter;

import org.springframework.stereotype.Component;

import com.freelance.app.dto.UserDto;
import com.freelance.app.entities.User;
import com.freelance.app.repositories.PersonRepository;
import com.freelance.app.services.ICompanyClientService;
import com.freelance.app.services.IPersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class UserConvertor implements GenericsConverter<User, UserDto> {

	private ICompanyClientService companyClientService;
	private IPersonService personService;

	@Override
	public UserDto entityToDto(User user) {
		return UserDto.builder()
				.email(user.getEmail())
				.password(user.getPassword())
				.personId(user.getPerson().getPersonId())
				.companyClientId(user.getCompanyClient().getCompanyId())
				.isActive(user.isActive())
				.build();
	}

	@Override
	public User dtoToEntity(UserDto userDto) {
		return User.builder()
				.email(userDto.getEmail())
				.password(userDto.getPassword())
				.person(personService.getPersonById(userDto.getPersonId()))
				.isActive(userDto.isActive())
				.build();
				
	}

}
