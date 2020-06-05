package com.freelance.app.converter;

import org.springframework.stereotype.Component;

import com.freelance.app.dto.CompanyClientDto;
import com.freelance.app.entities.CompanyClient;

@Component
public class CompanyClientConverter implements GenericsConverter<CompanyClient, CompanyClientDto> {

	@Override
	public CompanyClientDto entityToDto(CompanyClient companyClient) {
		// TODO Auto-generated method stub
		return CompanyClientDto.builder()
				.companyId(companyClient.getCompanyId())
				.companyName(companyClient.getCompanyName())
				.companyPhone(companyClient.getCompanyPhone())
				.companyLogo(companyClient.getCompanyLogo())
				.companyWebSite(companyClient.getCompanyWebSite())
				.firstNameContact(companyClient.getFirstNameContact())
				.lastNameContact(companyClient.getLastNameContact())
				.emailContact(companyClient.getEmailContact())
				.phoneContact(companyClient.getPhoneContact())
				.build();
	}

	@Override
	public CompanyClient dtoToEntity(CompanyClientDto companyClientDto) {
		// TODO Auto-generated method stub
		return CompanyClient.builder()
				.companyId(companyClientDto.getCompanyId())
				.companyName(companyClientDto.getCompanyName())
				.companyPhone(companyClientDto.getCompanyPhone())
				.companyLogo(companyClientDto.getCompanyLogo())
				.companyWebSite(companyClientDto.getCompanyWebSite())
				.firstNameContact(companyClientDto.getFirstNameContact())
				.lastNameContact(companyClientDto.getLastNameContact())
				.emailContact(companyClientDto.getEmailContact())
				.phoneContact(companyClientDto.getPhoneContact())
				.build();
		
	}

}
