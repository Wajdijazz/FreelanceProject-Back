package com.freelance.app.services;

import java.io.IOException;
import java.util.List;

import com.freelance.app.dto.CompanyClientDto;
import com.freelance.app.dto.Company_Person_Dto;
import com.freelance.app.entities.CompanyClient;

public interface ICompanyClientService {

	Company_Person_Dto createCompany(CompanyClientDto companyClientDto);

	CompanyClient getCompanyById(Long companyClientId);

	List<CompanyClientDto> getAllCompaniesClients();

	CompanyClientDto updateCompany(CompanyClientDto companyClientDto, Long companyClientId);

	void deleteCompanyById(Long companyClientId);

}
