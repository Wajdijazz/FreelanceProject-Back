package com.freelance.app.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.freelance.app.converter.LocalisationConverter;
import com.freelance.app.dto.LocalisationDto;
import com.freelance.app.entities.Localisation;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.repositories.LocalisationRepository;
import com.freelance.app.services.ILocalisationService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LocalisationServiceImpl implements ILocalisationService {

	private LocalisationRepository localisationRepository;
	private LocalisationConverter localisationConverter;

	@Override
	public Localisation createLocalisation(LocalisationDto localisationDto) {
		return localisationRepository.save(localisationConverter.dtoToEntity(localisationDto));
	}

	@Override
	public List<LocalisationDto> getAllLocalisation(Long companyId) {
		return localisationConverter
				.entityListToDtoList(localisationRepository.findByCompanyClient_CompanyId(companyId));
	}

	@Override
	public void deleteLocalisation(Long localisationId) {
		localisationRepository.deleteById(localisationId);
	}

	@Override
	public Localisation upadteLocalisation(LocalisationDto localisationDto) {
		Localisation localisationToUpdate = getLocalisationById(localisationDto.getLocalisationId());
		localisationToUpdate.setDescription(localisationDto.getDescription());
		localisationToUpdate.setIsInStock(localisationDto.getIsInStock());
		return localisationRepository.save(localisationToUpdate);
	}

	@Override
	public Localisation getLocalisationById(Long localisationId) {
		return localisationRepository.findById(localisationId).orElseThrow(
				() -> new ApplicationException("This Localisation with Id" + localisationId + "not exist"));
	}

}
