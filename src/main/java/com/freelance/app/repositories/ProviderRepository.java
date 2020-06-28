package com.freelance.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelance.app.entities.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
	List<Provider> findByCompanyClient_CompanyId(Long companyId);

}
