package com.freelance.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelance.app.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	List<Department> findByCompanyClient_CompanyId(Long companyId);

}
