package com.freelance.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.app.dto.PersonDto;
import com.freelance.app.security.ResponseMessage;
import com.freelance.app.services.IPersonService;
import com.freelance.app.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.PERSON)
@CrossOrigin(value = "*")
public class PersonController {
	
	private IPersonService personService;
	
	@PostMapping("/")
	public ResponseEntity<?> creatPerson(@RequestBody PersonDto personDto) {
		personService.createPerson(personDto);
		return new ResponseEntity<>(new ResponseMessage("Person created successfully!"), HttpStatus.OK);
	}


}
