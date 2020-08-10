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

import com.freelance.app.dto.DepartmentDto;
import com.freelance.app.security.ResponseMessage;
import com.freelance.app.services.IDepartmentService;
import com.freelance.app.util.Routes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(Routes.DEPARTMENT)
@CrossOrigin(value = "*")
public class DepartmentController {

	private IDepartmentService departmentService;

	@PostMapping("/")
	public ResponseEntity<?> creatDepartment(@RequestBody DepartmentDto departmentDto) {
		departmentService.createDepartment(departmentDto);
		return new ResponseEntity<>(new ResponseMessage("Department created successfully!"), HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDto departmentDto) {
		departmentService.updateDepartment(departmentDto);
		return new ResponseEntity<>(new ResponseMessage("Department updated successfully!"), HttpStatus.OK);
	}

	@GetMapping("/{companyId}")
	public List<DepartmentDto> getAllDepartments(@PathVariable(value = "companyId") Long companyId) {
		return departmentService.getAllDepartments(companyId);
	}

	@DeleteMapping("/{departmentId}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(value = "departmentId") Long departmentId) {
		departmentService.deleteDepartment(departmentId);
		return new ResponseEntity<>(new ResponseMessage("Department deleted successfully!"), HttpStatus.OK);
	}
}
