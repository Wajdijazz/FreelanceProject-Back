package com.freelance.app.services;

import com.freelance.app.dto.CompanyClientDto;
import com.freelance.app.entities.CompanyClient;

public interface ICompanyClientService {

	CompanyClient createCompany(CompanyClientDto companyClientDto);
	
	CompanyClient getCompanyById(Long companyClientId);

}
