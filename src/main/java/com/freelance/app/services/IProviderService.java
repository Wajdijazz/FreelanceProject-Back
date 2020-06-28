package com.freelance.app.services;

import java.util.List;

import com.freelance.app.dto.ProviderDto;
import com.freelance.app.entities.Provider;

public interface IProviderService {
	
	Provider createProvider(ProviderDto providerDto);
	
	List<ProviderDto> getAllProviders(Long companyId);
	
	Provider getProviderById(Long providerId);

	void deleteProvider(Long providerId);
	
	Provider updateProvider(ProviderDto providerDto);


}
