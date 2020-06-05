package com.freelance.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Person")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long personId;
	
	private String firstName;
	
	private String lastName;
	
	@Column(name = "phone_number")
	private int phoneNumber ;
	
	@Column(name = "date_creation")
	private LocalDate creationDate;	
	
	private boolean isActive;


}
