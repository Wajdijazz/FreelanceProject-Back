package com.freelance.app.services;

import com.freelance.app.dto.PersonDto;
import com.freelance.app.entities.Person;

public interface IPersonService {
	
	Person getPersonById(Long personId);
	
	PersonDto createPerson (PersonDto personDto);
	

}
