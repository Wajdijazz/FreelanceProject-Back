package com.freelance.app.services;

import java.util.List;

import com.freelance.app.dto.CompanyClientDto;
import com.freelance.app.entities.CompanyClient;

public interface ICompanyClientService {

	CompanyClientDto createCompany(CompanyClientDto companyClientDto);
	
	CompanyClient getCompanyById(Long companyClientId);
	
	List<CompanyClientDto> getAllCompaniesClients();
	
	CompanyClientDto updateCompany(CompanyClientDto companyClientDto, Long companyClientId);
	
	void deleteCompanyById(Long companyClientId);

}
