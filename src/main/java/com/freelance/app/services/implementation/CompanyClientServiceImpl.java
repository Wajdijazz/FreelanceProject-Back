package com.freelance.app.services.implementation;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.freelance.app.converter.CompanyClientConverter;
import com.freelance.app.dto.CompanyClientDto;
import com.freelance.app.dto.Company_Person_Dto;
import com.freelance.app.entities.CompanyClient;
import com.freelance.app.entities.Person;
import com.freelance.app.entities.User;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.exceptions.ResourceNotFoundException;
import com.freelance.app.repositories.CompanyClientRepository;
import com.freelance.app.repositories.PersonRepository;
import com.freelance.app.repositories.UserRepository;
import com.freelance.app.services.ICompanyClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class CompanyClientServiceImpl implements ICompanyClientService {

	private CompanyClientRepository companyClientRepository;
	private CompanyClientConverter companyClientConverter;
	private UserRepository userRepository;
	private PersonRepository personRepository;

	@Override
	public Company_Person_Dto createCompany(CompanyClientDto companyClientDto) {
		if (companyClientRepository.findByEmailContact(companyClientDto.getEmailContact()) != null)
			throw new ResourceNotFoundException("Email already exists");
		CompanyClient company = companyClientRepository.save(companyClientConverter.dtoToEntity(companyClientDto));
		Person personToSve = Person.builder().firstName(companyClientDto.getFirstNameContact())
				.lastName(companyClientDto.getLastNameContact()).phoneNumber(companyClientDto.getPhoneContact())
				.creationDate(LocalDate.now()).isActive(true).companyClient(company).build();
		Person person = personRepository.save(personToSve);
		Company_Person_Dto company_Person_Dto = Company_Person_Dto.builder().companyId(company.getCompanyId())
				.personId(person.getPersonId()).emailContact(company.getEmailContact()).build();
		return company_Person_Dto;
	}

	@Override
	public CompanyClient getCompanyById(Long companyClientId) {
		return companyClientRepository.findById(companyClientId)
				.orElseThrow(() -> new ApplicationException("This Company with Id" + companyClientId + "not exist"));
	}

	@Override
	public List<CompanyClientDto> getAllCompaniesClients() {
		return companyClientConverter.entityListToDtoList(companyClientRepository.findAll());
	}

	@Override
	public CompanyClientDto updateCompany(CompanyClientDto companyClientDto, Long companyClientId) {
		CompanyClientDto companyClientDtoUpdated = companyClientConverter.entityToDto(getCompanyById(companyClientId));

		companyClientDtoUpdated.setCompanyName(companyClientDto.getCompanyName());
		companyClientDtoUpdated.setCompanyWebSite(companyClientDto.getCompanyWebSite());
		companyClientDtoUpdated.setFirstNameContact(companyClientDto.getFirstNameContact());
		companyClientDtoUpdated.setLastNameContact(companyClientDto.getLastNameContact());
		companyClientDtoUpdated.setEmailContact(companyClientDto.getEmailContact());
		companyClientDtoUpdated.setPhoneContact(companyClientDto.getPhoneContact());
		return companyClientConverter
				.entityToDto(companyClientRepository.save(companyClientConverter.dtoToEntity(companyClientDtoUpdated)));
	}

	@Override
	public void deleteCompanyById(Long companyClientId) {
	/*	User user = userRepository.findByCompanyClient_CompanyId(companyClientId);
		if (user == null) {
			personRepository.deleteByCompanyClient_CompanyId(companyClientId);
			companyClientRepository.delete(getCompanyById(companyClientId));
		} else {*/
			userRepository.deleteByCompanyClient_CompanyId(companyClientId);
			personRepository.deleteByCompanyClient_CompanyId(companyClientId);
			companyClientRepository.delete(getCompanyById(companyClientId));
	
	}

}
