package com.freelance.app.converter;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.freelance.app.dto.LocalisationDto;
import com.freelance.app.entities.Localisation;
import com.freelance.app.services.ICompanyClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class LocalisationConverter implements GenericsConverter<Localisation, LocalisationDto> {
	private ICompanyClientService companyClientService;

	@Override
	public LocalisationDto entityToDto(Localisation localisation) {
		return LocalisationDto.builder().localisationId(localisation.getLocalisationId())
				.description(localisation.getDescription()).isInStock(localisation.getIsInStock())
				.isActive(true)
				.creationDate(localisation.getCreationDate())
				.companyId(localisation.getCompanyClient().getCompanyId()).build();
	}

	@Override
	public Localisation dtoToEntity(LocalisationDto localisationDto) {
		return Localisation.builder().localisationId(localisationDto.getLocalisationId())
				.description(localisationDto.getDescription()).isInStock(localisationDto.getIsInStock()).isActive(true)
				.creationDate(LocalDate.now())
				.companyClient(companyClientService.getCompanyById(localisationDto.getCompanyId())).build();
	}

}
