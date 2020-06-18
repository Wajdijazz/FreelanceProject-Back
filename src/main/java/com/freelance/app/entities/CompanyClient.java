package com.freelance.app.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.*;

@Entity
@Table(name = "Company_Client")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
/**
 * This class for the company client
 * 
 * @author WAJDI
 *
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CompanyClient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long companyId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_webSite")
	private String companyWebSite;

	@Column(name = "contact_firstName")
	private String firstNameContact;

	@Column(name = "contact_lastName")
	private String lastNameContact;

	@Column(name = "contact_email")
	private String emailContact;

	@Column(name = "contact_phone")
	private float phoneContact;

	@Column(name = "company_logo", length = 1000)
	private byte[] companyLogo;

}
