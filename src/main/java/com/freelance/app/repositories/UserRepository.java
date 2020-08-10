package com.freelance.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.freelance.app.entities.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

	void deleteByCompanyClient_CompanyId(Long companyId);
		
	List<User> findByCompanyClient_CompanyId(Long companyId);


}
