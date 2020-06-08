package com.freelance.app.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Entity
@Table(name = "Role")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * this class has the role of each user
 * 
 * @author WAJDI
 *
 */
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String roleDescription;

}
