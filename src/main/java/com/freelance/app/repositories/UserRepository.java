package com.freelance.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.freelance.app.entities.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

	void deleteByCompanyClient_CompanyId(Long companyId);

}
