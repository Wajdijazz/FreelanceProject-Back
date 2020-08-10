package com.freelance.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freelance.app.entities.ItemFamily;

@Repository
public interface ItemFamilyRepository extends JpaRepository<ItemFamily, Long> {
	List<ItemFamily> findByCompanyClient_CompanyId(Long companyId);

}
