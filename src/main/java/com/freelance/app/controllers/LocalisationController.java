package com.freelance.app.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.app.dto.LocalisationDto;
import com.freelance.app.security.ResponseMessage;
import com.freelance.app.services.ILocalisationService;
import com.freelance.app.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.LOCALISATION)
@CrossOrigin(value = "*")
public class LocalisationController {

	private ILocalisationService localisationService;

	@PostMapping("/")
	public ResponseEntity<?> creatLocalisation(@RequestBody LocalisationDto localisationDto) {
		localisationService.createLocalisation(localisationDto);
		return new ResponseEntity<>(new ResponseMessage("Localisation created successfully!"), HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<?> updatetLocalisation(@RequestBody LocalisationDto localisationDto) {
		localisationService.upadteLocalisation(localisationDto);
		return new ResponseEntity<>(new ResponseMessage("Localisation update successfully!"), HttpStatus.OK);
	}

	@GetMapping("/{companyId}")
	public List<LocalisationDto> getAllLocalisation(@PathVariable(value = "companyId") Long companyId) {
		return localisationService.getAllLocalisation(companyId);
	}

	@DeleteMapping("/{localisationId}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(value = "localisationId") Long localisationId) {
		localisationService.deleteLocalisation(localisationId);
		return new ResponseEntity<>(new ResponseMessage("Localisation deleted successfully!"), HttpStatus.OK);
	}

}
