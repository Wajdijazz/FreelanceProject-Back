package com.freelance.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

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
public class ProviderDto {
	
	
	private Long providerId;
	
	private String name;
	
	@Column(name = "date_creation")
	private LocalDate creationDate;

	private boolean isActive;
	
	private Long companyId;

}
