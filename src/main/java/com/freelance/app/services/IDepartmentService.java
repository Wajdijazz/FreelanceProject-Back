package com.freelance.app.services;

import java.util.List;

import com.freelance.app.dto.DepartmentDto;
import com.freelance.app.entities.Department;

public interface IDepartmentService {

	Department createDepartment(DepartmentDto departmentDto);

	List<DepartmentDto> getAllDepartments(Long companyId);
	
	Department getDepartmentById(Long departmentId);

	void deleteDepartment(Long departmentId);
	
	Department updateDepartment(DepartmentDto departmentDto);
	
	
	

}
