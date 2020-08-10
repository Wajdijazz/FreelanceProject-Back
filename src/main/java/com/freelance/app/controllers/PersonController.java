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
import com.freelance.app.dto.PersonDto;
import com.freelance.app.entities.Person;
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

	@PutMapping("/")
	public ResponseEntity<?> updatePerson(@RequestBody PersonDto personDto) {
		personService.updatePerson(personDto);
		return new ResponseEntity<>(new ResponseMessage("Person update successfully!"), HttpStatus.OK);
	}

	@GetMapping("/{companyId}")
	public List<Person> getAllAllPersons(@PathVariable(value = "companyId") Long companyId) {
		return personService.getPersons(companyId);
	}

	@GetMapping("/personList/{companyId}")
	public List<Person> getPersonListToAffectToUsers(@PathVariable(value = "companyId") Long companyId) {
		return personService.getPersonListToAffectToUsers(companyId);
	}

	@DeleteMapping("/{personId}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "personId") Long personId) {
		personService.deletePerson(personId);
		return new ResponseEntity<>(new ResponseMessage("Person deleted successfully!"), HttpStatus.OK);
	}

}
