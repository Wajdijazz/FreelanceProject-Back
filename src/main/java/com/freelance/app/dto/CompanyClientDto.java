package com.freelance.app.dto;


import org.springframework.web.multipart.MultipartFile;
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
public class CompanyClientDto {

	private Long companyId;

	private String companyName;

	private String companyWebSite;

	private String firstNameContact;

	private String lastNameContact;

	private String emailContact;

	private double phoneContact;

	private MultipartFile companyLogo;

}
