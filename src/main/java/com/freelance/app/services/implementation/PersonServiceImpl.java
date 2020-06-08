package com.freelance.app.services.implementation;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.freelance.app.entities.Person;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.repositories.PersonRepository;
import com.freelance.app.services.IPersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class PersonServiceImpl implements IPersonService{
	
	private PersonRepository personRepository;

	@Override
	public Person getPersonById(Long personId) {
		return personRepository.findById(personId)
				.orElseThrow(() -> new ApplicationException("This person with Id" + personId + "not exist"));
	}

}
