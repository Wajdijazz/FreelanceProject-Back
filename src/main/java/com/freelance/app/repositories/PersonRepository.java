package com.freelance.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.freelance.app.entities.Person;


@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {

}
