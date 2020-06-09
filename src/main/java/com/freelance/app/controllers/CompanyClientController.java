package com.freelance.app.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.app.converter.CompanyClientConverter;
import com.freelance.app.dto.CompanyClientDto;
import com.freelance.app.services.ICompanyClientService;
import com.freelance.app.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.COMPANYCLIENT)
public class CompanyClientController {

	private ICompanyClientService companyClientService;
	private CompanyClientConverter companyClientConverter;

	@PostMapping("/")
	public CompanyClientDto creatCompanyClient(@RequestBody CompanyClientDto companyClientDto) {
		return companyClientConverter.entityToDto(companyClientService.createCompany(companyClientDto));
	}

}
