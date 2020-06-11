package com.freelance.app.services.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.freelance.app.converter.CompanyClientConverter;
import com.freelance.app.dto.CompanyClientDto;
import com.freelance.app.entities.CompanyClient;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.repositories.CompanyClientRepository;
import com.freelance.app.services.ICompanyClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class CompanyClientServiceImpl implements ICompanyClientService {

	private CompanyClientRepository companyClientRepository;
	private CompanyClientConverter companyClientConverter;

	@Override
	public CompanyClientDto createCompany(CompanyClientDto companyClientDto) {
		return companyClientConverter
				.entityToDto((companyClientRepository.save(companyClientConverter.dtoToEntity(companyClientDto))));
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
		companyClientRepository.delete(getCompanyById(companyClientId));
	}

}
