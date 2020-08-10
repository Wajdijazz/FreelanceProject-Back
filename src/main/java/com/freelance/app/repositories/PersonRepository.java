package com.freelance.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.freelance.app.entities.Person;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {

	void deleteByCompanyClient_CompanyId(Long companyId);

	List<Person> findByCompanyClient_CompanyId(Long companyId);

	@Modifying
	@Query(value = " select * FROM person p WHERE p.company_client_id=:companyId and person_id not in ( SELECT person_id from user)", nativeQuery = true)
	List<Person> findPersonsByCompany(Long companyId);

}
