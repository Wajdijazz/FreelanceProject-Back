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

import com.freelance.app.dto.ProviderDto;
import com.freelance.app.security.ResponseMessage;
import com.freelance.app.services.IProviderService;
import com.freelance.app.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.Provider)
@CrossOrigin(value = "*")
public class ProviderController {
	
	private IProviderService providerService;
	
	@PostMapping("/")
	public ResponseEntity<?> creatProvider(@RequestBody ProviderDto providerDto) {
		providerService.createProvider(providerDto);
		return new ResponseEntity<>(new ResponseMessage("Provider created successfully!"), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateProvider(@RequestBody ProviderDto providerDto) {
		providerService.updateProvider(providerDto);
		return new ResponseEntity<>(new ResponseMessage("Provider updated successfully!"), HttpStatus.OK);
	}
	@GetMapping("/{companyId}")
	public List<ProviderDto> getAllProviders(@PathVariable(value = "companyId") Long companyId) {
		return providerService.getAllProviders(companyId);
	}

	@DeleteMapping("/{providerId}")
	public ResponseEntity<?> deleteProvider(@PathVariable(value = "providerId") Long providerId) {
		providerService.deleteProvider(providerId);
		return new ResponseEntity<>(new ResponseMessage("Provider deleted successfully!"), HttpStatus.OK);
	}

}
