package com.freelance.app.converter;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.freelance.app.dto.DepartmentDto;
import com.freelance.app.entities.Department;
import com.freelance.app.services.ICompanyClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DepartmentConvertor implements GenericsConverter<Department, DepartmentDto> {

	private ICompanyClientService companyClientService;

	@Override
	public DepartmentDto entityToDto(Department department) {
		// TODO Auto-generated method stub
		return DepartmentDto.builder().companyClientId(department.getCompanyClient().getCompanyId())
				.departmentName(department.getDepartmentName()).creationDate(LocalDate.now())
				.departmentId(department.getDepartmentId()).isActive(true).build();
	}

	@Override
	public Department dtoToEntity(DepartmentDto departmentDto) {
		// TODO Auto-generated method stub
		return Department.builder()
				.companyClient(companyClientService.getCompanyById(departmentDto.getCompanyClientId()))
				.departmentName(departmentDto.getDepartmentName()).creationDate(LocalDate.now())
				.departmentId(departmentDto.getDepartmentId()).isActive(true).build();
	}

}
