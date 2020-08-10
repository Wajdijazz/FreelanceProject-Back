package com.freelance.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freelance.app.entities.Localisation;

@Repository
public interface LocalisationRepository extends JpaRepository<Localisation, Long> {
	List<Localisation> findByCompanyClient_CompanyId(Long companyId);
}
