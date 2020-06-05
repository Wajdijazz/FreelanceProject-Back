package com.freelance.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.freelance.app.entities.Role;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleDescription(String roleDescription);

}
