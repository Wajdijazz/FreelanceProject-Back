package com.freelance.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.freelance.app.entities.Person;


@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	void deleteByCompanyClient_CompanyId(Long companyId);

	List<Person> findByCompanyClient_CompanyId(Long companyId);

}
