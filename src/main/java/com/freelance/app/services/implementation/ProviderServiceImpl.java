package com.freelance.app.services.implementation;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.freelance.app.converter.ProviderConvertor;
import com.freelance.app.dto.ProviderDto;
import com.freelance.app.entities.Provider;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.repositories.ProviderRepository;
import com.freelance.app.services.ICompanyClientService;
import com.freelance.app.services.IProviderService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class ProviderServiceImpl implements IProviderService {

	private ProviderRepository providerRepository;
	private ProviderConvertor providerConvertor;
	private ICompanyClientService companyCientService;


	@Override
	public Provider createProvider(ProviderDto providerDto) {
		return providerRepository.save(providerConvertor.dtoToEntity(providerDto));
	}

	@Override
	public List<ProviderDto> getAllProviders(Long companyId) {
		return providerConvertor.entityListToDtoList(providerRepository.findByCompanyClient_CompanyId(companyId));
	}

	@Override
	public Provider getProviderById(Long providerId) {
		return providerRepository.findById(providerId)
				.orElseThrow(() -> new ApplicationException("This Provider with Id" + providerId + "not exist"));
	}

	@Override
	public void deleteProvider(Long providerId) {
		providerRepository.deleteById(providerId);
	}

	@Override
	public Provider updateProvider(ProviderDto providerDto) {
		Provider providerToUpdate = getProviderById(providerDto.getProviderId());
		providerToUpdate.setName(providerDto.getName());
		providerToUpdate.setCreationDate(LocalDate.now());
		providerToUpdate.setActive(true);
		providerToUpdate.setCompanyClient(companyCientService.getCompanyById(providerDto.getCompanyId()));
		return providerRepository.save(providerToUpdate);
	}

}
