package com.freelance.app.services;

import java.util.List;

import com.freelance.app.dto.PersonDto;
import com.freelance.app.entities.Person;

public interface IPersonService {

	Person getPersonById(Long personId);

	PersonDto createPerson(PersonDto personDto);

	List<Person> getPersons(Long companyId);

	void deletePerson(Long personId);

	Person updatePerson(PersonDto personDto);

	List<Person> getPersonListToAffectToUsers(Long companyId);

}
