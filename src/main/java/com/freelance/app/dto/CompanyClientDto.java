package com.freelance.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class CompanyClientDto {

	private Long companyId;

	private String companyName;

	private String companyWebSite;

	private String firstNameContact;

	private String lastNameContact;

	private String emailContact;

	private float phoneContact;

	private byte[] companyLogo;

}
