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

import com.freelance.app.dto.CompanyClientDto;
import com.freelance.app.security.ResponseMessage;
import com.freelance.app.services.ICompanyClientService;
import com.freelance.app.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.COMPANYCLIENT)
@CrossOrigin(value = "*")
public class CompanyClientController {

	private ICompanyClientService companyClientService;

	@PostMapping("/")
	public ResponseEntity<?> creatCompanyClient(@RequestBody CompanyClientDto companyClientDto) {
		companyClientService.createCompany(companyClientDto);
		return new ResponseEntity<>(new ResponseMessage("Company created successfully!"), HttpStatus.OK);
	}

	@GetMapping("/")
	public List<CompanyClientDto> getAllClient() {
		return companyClientService.getAllCompaniesClients();
	}

	@PutMapping("/{companyClientId}")
	public ResponseEntity<?> updateCompanyClient(@RequestBody CompanyClientDto companyClientDto,
			@PathVariable(value = "companyClientId") Long companyClientId) {
		companyClientService.updateCompany(companyClientDto, companyClientId);
		return new ResponseEntity<>(new ResponseMessage("Company updated successfully!"), HttpStatus.OK);
	}

	@DeleteMapping("/{companyClientId}")
	public ResponseEntity<?> deleteCompanyClient(@PathVariable(value = "companyClientId") Long companyClientId) {
		companyClientService.deleteCompanyById(companyClientId);
		return new ResponseEntity<>(new ResponseMessage("Company deleted successfully!"), HttpStatus.OK);
	}

}
