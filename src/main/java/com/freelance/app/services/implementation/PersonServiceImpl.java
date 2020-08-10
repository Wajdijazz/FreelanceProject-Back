package com.freelance.app.services.implementation;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.freelance.app.converter.PersonConvertor;
import com.freelance.app.dto.PersonDto;
import com.freelance.app.entities.Person;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.repositories.PersonRepository;
import com.freelance.app.services.ICompanyClientService;
import com.freelance.app.services.IDepartmentService;
import com.freelance.app.services.IPersonService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class PersonServiceImpl implements IPersonService {

	private PersonRepository personRepository;
	private PersonConvertor personConvertor;
	private ICompanyClientService companyCientService;
	private IDepartmentService departmentService;

	@Override
	public Person getPersonById(Long personId) {
		return personRepository.findById(personId)
				.orElseThrow(() -> new ApplicationException("This person with Id" + personId + "not exist"));
	}

	@Override
	public PersonDto createPerson(PersonDto personDto) {
		return personConvertor.entityToDto(personRepository.save(personConvertor.dtoToEntity(personDto)));
	}

	@Override
	public List<Person> getPersons(Long companyId) {
		return personRepository.findByCompanyClient_CompanyId(companyId);
	}

	@Override
	public void deletePerson(Long personId) {
		personRepository.deleteById(personId);
	}

	@Override
	public Person updatePerson(PersonDto personDto) {
		Person personToUpdate = getPersonById(personDto.getPersonId());
		personToUpdate.setFirstName(personDto.getFirstName());
		personToUpdate.setLastName(personDto.getLastName());
		personToUpdate.setCreationDate(LocalDate.now());
		personToUpdate.setActive(true);
		personToUpdate.setCompanyClient(companyCientService.getCompanyById(personDto.getCompanyId()));
		personToUpdate.setDepartment(departmentService.getDepartmentById(personDto.getDepartmentId()));
		return personRepository.save(personToUpdate);
	}

	@Override
	public List<Person> getPersonListToAffectToUsers(Long companyId) {
		return personRepository.findPersonsByCompany(companyId);
	}

}
