package com.freelance.app.services.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.freelance.app.converter.DepartmentConvertor;
import com.freelance.app.dto.DepartmentDto;
import com.freelance.app.entities.Department;
import com.freelance.app.exceptions.ApplicationException;
import com.freelance.app.repositories.DepartmentRepository;
import com.freelance.app.services.ICompanyClientService;
import com.freelance.app.services.IDepartmentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class DepartmentService implements IDepartmentService {

	private DepartmentRepository departmentRepository;
	private DepartmentConvertor departmentConvertor;
	private ICompanyClientService companyCientService;

	@Override
	public Department createDepartment(DepartmentDto departmentDto) {
		return departmentRepository.save(departmentConvertor.dtoToEntity(departmentDto));
	}

	@Override
	public List<DepartmentDto> getAllDepartments(Long companyId) {
		List<DepartmentDto> departmentDtoList = departmentConvertor
				.entityListToDtoList(departmentRepository.findByCompanyClient_CompanyId(companyId));
		List<DepartmentDto> departmentDtos  = departmentDtoList.stream()
		  .filter(c -> !"Admin_Department_Contact_Company_Client".equals(c.getDepartmentName()))
		  .collect(Collectors.toList());
		return departmentDtos;
	}

	@Override
	public void deleteDepartment(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(DepartmentDto departmentDto) {
		Department departmentToUpdate = getDepartmentById(departmentDto.getDepartmentId());
		departmentToUpdate.setDepartmentName(departmentDto.getDepartmentName());
		departmentToUpdate.setCreationDate(LocalDate.now());
		departmentToUpdate.setCompanyClient(companyCientService.getCompanyById(departmentDto.getCompanyClientId()));
		departmentToUpdate.setActive(true);
		return departmentRepository.save(departmentToUpdate);
	}

	@Override
	public Department getDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ApplicationException("This department with Id" + departmentId + "not exist"));
	}

}
