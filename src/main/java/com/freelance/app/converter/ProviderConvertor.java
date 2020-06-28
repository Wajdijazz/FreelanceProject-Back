package com.freelance.app.converter;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.freelance.app.dto.ProviderDto;
import com.freelance.app.entities.Provider;
import com.freelance.app.services.ICompanyClientService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ProviderConvertor implements GenericsConverter<Provider, ProviderDto> {

	private ICompanyClientService companClientService;

	@Override
	public ProviderDto entityToDto(Provider provider) {
		return ProviderDto.builder().providerId(provider.getProviderId()).name(provider.getName())
				.creationDate(LocalDate.now()).isActive(true).companyId(provider.getCompanyClient().getCompanyId())
				.build();
	}

	@Override
	public Provider dtoToEntity(ProviderDto providerDto) {
		return Provider.builder().providerId(providerDto.getProviderId()).name(providerDto.getName())
				.creationDate(LocalDate.now()).isActive(true)
				.companyClient(companClientService.getCompanyById(providerDto.getCompanyId())).build();
	}

}
