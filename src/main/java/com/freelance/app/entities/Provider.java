package com.freelance.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * this class describ entity provider (fournisseur de materielles)
 * 
 * @author WAJDI
 *
 */
@Entity
@Table(name = "provider")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long providerId;
	
	private String name;
	
	@Column(name = "date_creation")
	private LocalDate creationDate;

	private boolean isActive;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "companyClient_id")
	private CompanyClient companyClient;

}
