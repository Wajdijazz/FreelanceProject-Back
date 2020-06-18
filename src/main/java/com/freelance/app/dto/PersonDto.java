package com.freelance.app.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PersonDto {

	private Long personId;

	private String firstName;

	private String lastName;

	private float phoneNumber;

	private LocalDate creationDate;

	private boolean isActive;
	
	private Long companyId;

}
