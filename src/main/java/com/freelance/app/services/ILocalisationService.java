package com.freelance.app.services;

import java.util.List;

import com.freelance.app.dto.LocalisationDto;
import com.freelance.app.entities.Localisation;

public interface ILocalisationService {

	Localisation createLocalisation(LocalisationDto localisationDto);

	List<LocalisationDto> getAllLocalisation(Long companyId);
	
	Localisation getLocalisationById(Long localisationId);

	void deleteLocalisation(Long localisationId);

	Localisation upadteLocalisation(LocalisationDto localisationDto);


}
