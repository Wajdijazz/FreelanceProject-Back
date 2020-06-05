package com.freelance.app.services.implementation;

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
	public CompanyClient createCompany(CompanyClientDto companyClientDto) {
		// TODO Auto-generated method stub
		return companyClientRepository.save(companyClientConverter.dtoToEntity(companyClientDto));
	}

	@Override
	public CompanyClient getCompanyById(Long companyClientId) {
		// TODO Auto-generated method stub
		return companyClientRepository.findById(companyClientId)
				.orElseThrow(() -> new ApplicationException("This Company with Id" + companyClientId + "not exist"));
	}

}
